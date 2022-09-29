package com.techelevator.dao;

import com.techelevator.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDAO implements CollectionDAO{

    private JdbcTemplate jdbcTemplate;
    Collection collection = new Collection();

    public JdbcCollectionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Collection> getAllCollection() {
        List<Collection> collectionList = new ArrayList<>();
        String sql = "SELECT * FROM collections";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if (result.next()) {
           collectionList.add(mapRowToCollection(result));
        }
        return collectionList;
    }

    @Override
    public List<Collection> getCollectionByUserId(Long userId) {
         List<Collection> collectionListByUserId = new ArrayList<>();
         String sql = "SELECT * FROM collections WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        if (result.next()) {
            collectionListByUserId.add(mapRowToCollection(result));
        }

        return collectionListByUserId;
    }

    @Override
    public List<Collection> getCollectionByCollectionName(String collectionName) {
        List<Collection> collectionListByName = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE collection_name= ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionName);
        if (result.next()) {
            collectionListByName.add(mapRowToCollection(result));
        }

        return collectionListByName;
    }


    @Override
    public boolean getCollectionStatusPremium() {

        return false;
    }

    @Override
    public void createCollection(Collection newCollection) {

    }

    @Override
    public void deleteCollection(long collectionId) {

    }

    @Override
    public List<Collection> getCollectionByCollectionId(long collectionId) {
        List<Collection> collectionListByCollectionId = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE collection_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionId);
        if (result.next()) {
            collectionListByCollectionId.add(mapRowToCollection(result));
        }
        return collectionListByCollectionId;
    }

    private Collection mapRowToCollection(SqlRowSet result){
        Collection collection = new Collection();
        collection.setCollectionId(result.getInt("collection_id"));
        collection.setCollectionName(result.getString("collection_name"));
        collection.setPublic(result.getBoolean("is_public"));
        collection.setUserId(result.getLong("user_id"));
                return collection;

    }
}
