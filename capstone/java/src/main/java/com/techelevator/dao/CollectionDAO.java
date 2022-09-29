package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDAO {
    List<Collection> getAllCollection();
    List<Collection> getCollectionByUserId(Long userId);
    List<Collection> getCollectionByCollectionName(String collectionName);
    List<Collection> getAllPublicCollection(boolean isPublic);
    void createCollection(Collection newCollection);
    void deleteCollection(long collectionId);
    List<Collection> getCollectionByCollectionId(long collectionId);





}
