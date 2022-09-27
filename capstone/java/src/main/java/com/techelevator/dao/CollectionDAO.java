package com.techelevator.dao;

import java.util.Collection;
import java.util.List;

public interface CollectionDAO {
    List<Collection> getAllCollection();
    List<Collection> getCollectionByUserId(Long userId);
    List<Collection> getCollectionByComicId(long comicId);
    boolean getCollectionStatusPremium();
    void createCollection();
    List<Collection> getCollectionByCollectionId(long collectionId);




}
