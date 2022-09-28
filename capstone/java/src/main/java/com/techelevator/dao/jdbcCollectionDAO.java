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
        return collectionList;
    }

    @Override
    public List<Collection> getCollectionByUserId(Long userId) {
         List<Collection> collectionListByUserId = new ArrayList<>();
         String sql = "SELECT * FROM collections WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        return collectionListByUserId;
    }

    @Override
    public List<Collection> getCollectionByCollectionName(String collectionName) {
        List<Collection> collectionListByName = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE collection_name= ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionName);

        return collectionListByName;
    }


    @Override
    public boolean getCollectionStatusPremium() {
        return false;
    }

    @Override
    public void createCollection(java.util.Collection newCollection) {

    }


    @Override
    public void createCollection(Collection newCollection) {

    }

    @Override
    public void deleteCollection(long collectionId) {

    }

    @Override
    public List<Collection> getCollectionByCollectionId(long collectionId) {
        return null;
    }

    private Collection mapRowtoCollection(SqlRowSet result){
        Collection collection = new Collection();
        collection.setCollectionId(result.getInt("collection_id"));
                return collection;
    }
}
