package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.util.List;

public interface ComicDAO {
    List<Comic> getAllComics();
    Comic getComicByComicId(long comicId);
    List<Comic> getComicsByTitle(String title);
    List<Comic> getComicsByGenre(String genre);
    List<Comic> getComicsByAuthor(String author);
    List<Comic> getComicsByVolume(String volume);
    boolean createComic(long comicId, String title, String genre, String author, int issueNumber);

}