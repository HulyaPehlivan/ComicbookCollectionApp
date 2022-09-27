package com.techelevator.dao;

import java.util.Collection;
import java.util.List;

public class jdbcCollectionDAO implements CollectionDAO{
    @Override
    public List<Collection> getAllCollection() {
        return null;
    }

    @Override
    public List<Collection> getCollectionByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Collection> getCollectionByComicId(long comicId) {
        return null;
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
        return null;
    }
}
