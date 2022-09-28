package com.techelevator.dao;

import java.util.Collection;
import java.util.List;

public interface CollectionDAO {
    List<com.techelevator.model.Collection> getAllCollection();
    List<com.techelevator.model.Collection> getCollectionByUserId(Long userId);
    List<com.techelevator.model.Collection> getCollectionByCollectionName(String collectionName);
    boolean getCollectionStatusPremium();
    void createCollection(Collection newCollection);

    void createCollection(com.techelevator.model.Collection newCollection);

    void deleteCollection(long collectionId);
    List<com.techelevator.model.Collection> getCollectionByCollectionId(long collectionId);





}
