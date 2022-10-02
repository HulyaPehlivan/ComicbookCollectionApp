package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.util.List;

public interface ComicDAO {
    List<Comic> getAllComics();
    Comic getComicByComicId(int comicId);
    List<Comic> getComicsByTitle(String title);
    List<Comic> getComicsByGenre(String genre);
    List<Comic> getComicsByAuthor(String author);
    List<Comic> getComicsByVolume(String volume);
    List<Comic> getComicsByCollectionId(int collection_id);
    void addComicIntoCollection(int comicId,int collection_id);
    void deleteComicFromCollection(int comicId, int collection_id);
    void createComic(Comic newComic, int comicId, int collection_id);

}