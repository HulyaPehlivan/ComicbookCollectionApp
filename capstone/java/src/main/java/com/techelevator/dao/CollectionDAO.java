package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDAO {
    List<com.techelevator.model.Collection> getAllCollection();
    List<com.techelevator.model.Collection> getCollectionByUserId(Long userId);
    List<com.techelevator.model.Collection> getCollectionByCollectionName(String collectionName);
    List<Collection> getAllPublicCollection(boolean isPublic);
    void createCollection(com.techelevator.model.Collection newCollection);
    void deleteCollection(long collectionId);
    List<com.techelevator.model.Collection> getCollectionByCollectionId(long collectionId);





}
