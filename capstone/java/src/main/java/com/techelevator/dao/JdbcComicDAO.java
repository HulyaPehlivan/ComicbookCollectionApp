package com.techelevator.dao;

import com.techelevator.model.Comic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcComicDAO implements ComicDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcComicDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comic> getAllComics() {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
//            comicList.add()
        }
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
