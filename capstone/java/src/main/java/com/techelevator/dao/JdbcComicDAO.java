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
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public Comic getComicByComicId(long comicId) {
        Comic comic = new Comic();
        String sql = "SELECT * FROM comics WHERE comic_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, comicId);
        if (result.next()){
            comic = mapRowToComic(result);
        }
        return comic;
    }

    @Override
    public List<Comic> getComicsByTitle(String title) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE title = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, title);
        while (result.next()){
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public List<Comic> getComicsByGenre(String genre) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE genre = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, genre);
        while (result.next()){
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public List<Comic> getComicsByAuthor(String author) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE author = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, author);
        while (result.next()){
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public List<Comic> getComicsByVolume(String volume) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE volume = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, volume);
        while (result.next()){
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public void createComic(Comic newComic) {
        String sql = "INSERT INTO comics(title, volume, issue_number, genre, author, release_date, in_store_date, image, deck, icon_URL, api_ID, description, publisher)";
        jdbcTemplate.update(sql, newComic.getTitle(), newComic.getVolume(), newComic.getIssueNumber(), newComic.getGenre(), newComic.getAuthor(), newComic.getReleaseDate(), newComic.getInStoreDate(),
                newComic.getImage(), newComic.getDeck(),newComic.getIconURL(), newComic.getApiID(), newComic.getDescription(), newComic.getPublisher());
    }

    private Comic mapRowToComic(SqlRowSet result){
        Comic comic = new Comic();
        comic.setComicId(result.getInt("comic_id"));
        comic.setTitle(result.getString("title"));
        comic.setVolume(result.getString("volume"));
        comic.setIssueNumber(result.getInt("issue_number"));
        comic.setGenre(result.getString("genre"));
        comic.setAuthor(result.getString("author"));
        comic.setReleaseDate(result.getString("release_date"));
        comic.setInStoreDate(result.getDate("in_store_date"));
        comic.setImage(result.getString("image"));
        comic.setDeck(result.getString("deck"));
        comic.setIconURL(result.getString("icon_URL"));
        comic.setApiID(result.getInt("api_ID"));
        comic.setDescription(result.getString("description"));
        comic.setPublisher(result.getString("publisher"));

        return comic;
    }



}
