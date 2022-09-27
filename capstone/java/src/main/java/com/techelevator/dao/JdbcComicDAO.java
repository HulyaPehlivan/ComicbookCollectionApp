package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.util.List;

public class JdbcComicDAO implements ComicDAO{
    @Override
    public List<Comic> getAllComics() {
        return null;
    }

    @Override
    public Comic getComicByComicId(long comicId) {
        return null;
    }

    @Override
    public List<Comic> getComicsByTitle(String title) {
        return null;
    }

    @Override
    public List<Comic> getComicsByGenre(String genre) {
        return null;
    }

    @Override
    public List<Comic> getComicsByAuthor(String author) {
        return null;
    }

    @Override
    public List<Comic> getComicsByVolume(String volume) {
        return null;
    }

    @Override
    public boolean createComic(long comicId, String title, String genre, String author, int issueNumber) {
        return false;
    }
}
