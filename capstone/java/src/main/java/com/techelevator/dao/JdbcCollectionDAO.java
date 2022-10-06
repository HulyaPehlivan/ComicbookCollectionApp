package com.techelevator.dao;

import com.techelevator.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDAO implements CollectionDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcCollectionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Collection> getAllCollection() {
        List<Collection> collectionList = new ArrayList<>();
        String sql = "SELECT * FROM collections";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
           collectionList.add(mapRowToCollection(result));
        }
        return collectionList;
    }

    @Override
    public List<Collection> getCollectionByUserId(int userId) {
         List<Collection> collectionListByUserId = new ArrayList<>();
         String sql = "SELECT collections.collection_id, collection_name, is_public, user_id, COUNT(comics.title) AS num_of_comics " +
                 "FROM collections " +
                 "JOIN comics ON comics.collection_id = collections.collection_id " +
                 "WHERE user_id = ? " +
                 "GROUP BY collections.collection_id";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        while(result.next()) {
            collectionListByUserId.add(mapRowToCollection(result));
        }
        return collectionListByUserId;
    }

    @Override
    public List<Collection> getCollectionByCollectionName(String collectionName, int userId) {
        List<Collection> collectionListByName = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE collection_name= ?  AND user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionName, userId);
        while(result.next()) {
            collectionListByName.add(mapRowToCollection(result));
        }
        return collectionListByName;
    }

    @Override
    public List<Collection> getAllPublicCollection() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE is_public = true";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            collections.add(mapRowToCollection(result));
        }
        return collections;
    }

    @Override
    public Collection createCollection(Collection newCollection, int userId) {
        String sql ="INSERT INTO collections (collection_name, is_public, user_id) VALUES (?,?,?)";
        jdbcTemplate.update(sql,newCollection.getCollectionName(), newCollection.isPublic(),userId);
        return newCollection;
    }

    @Override
    public void deleteCollection(int collectionId) {
        String sql = "DELETE FROM comics WHERE collection_id = ?;";
        jdbcTemplate.update(sql, collectionId);
        sql = "DELETE FROM collections WHERE collection_id = ?;";
        jdbcTemplate.update(sql, collectionId);
    }

    @Override
    public List<Collection> getCollectionByCollectionId(int collectionId) {
        List<Collection> collectionListByCollectionId = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE collection_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionId);
       while (result.next()) {
            collectionListByCollectionId.add(mapRowToCollection(result));
        }
        return collectionListByCollectionId;
    }

    @Override
    public void updateCollection(Collection collection) {
        String sql = "UPDATE collections  SET collection_name = ?, is_public = ?, user_id = ? WHERE collection_id = ?;";
         Integer updatedNo = jdbcTemplate.update(sql, collection.getCollectionName(), collection.isPublic(), collection.getUserId(), collection.getCollectionId());
        if(updatedNo == 1){
            System.out.println(updatedNo);
        } else {
            System.out.println("Update failed");
        }
    }

    private Collection mapRowToCollection(SqlRowSet result){
        Collection collection = new Collection();
        collection.setCollectionId(result.getInt("collection_id"));
        collection.setCollectionName(result.getString("collection_name"));
        collection.setIsPublic(result.getBoolean("is_public"));
        collection.setUserId(result.getInt("user_id"));
        collection.setNum_of_comics(result.getInt("num_of_comics"));
                return collection;

    }
}
