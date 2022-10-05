package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.util.List;

public interface ComicDAO {
    List<Comic> getAllComics();
    Comic getComicByComicId(int comicId);
    List<Comic> getComicsByTitle(String title);
    List<Comic> getComicsByVolume(String volume);
    List<Comic> getComicsByCollectionId(int collection_id);
    void deleteComicFromCollection(int collection_id, int apiID);
    void createComic(Comic newComic, int comicId, int collection_id);
    void updateComicQuantity(Comic comic, int comicId);
    Comic getComicByCollectionAndAPIID(int collection_id, int apiID);



}