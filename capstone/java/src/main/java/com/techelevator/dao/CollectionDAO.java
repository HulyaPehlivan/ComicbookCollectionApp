package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDAO {
    List<Collection> getAllCollection();
    List<Collection> getCollectionByUserId(int userId);
    List<Collection> getCollectionByCollectionName(String collectionName, int userId);
    List<Collection> getAllPublicCollection();
    Collection createCollection(Collection newCollection, int userId);
    void deleteCollection(int collectionId);
    List<Collection> getCollectionByCollectionId(int collectionId);
    void updateCollection(Collection collection);


}
