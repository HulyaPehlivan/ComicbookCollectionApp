package com.techelevator.dao;

import com.techelevator.model.Comic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
    public Comic getComicByComicId(int comicId) {
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
    public List<Comic> getComicsByCollectionId(int collection_id) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE collection_id = ?";
//        String sql = "SELECT * FROM comics WHERE comic_id IN (SELECT comic_id FROM collections WHERE collection_id = ?)";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collection_id);
        while (result.next()){
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public void addComicIntoCollection(int comicId, int collection_id) {
        String sql = "INSERT INTO collections (collection_id, comic_id) VALUES (?,?)";
        jdbcTemplate.update(sql, collection_id, comicId);

    }

    @Override
    public void deleteComicFromCollection(int comicId, int collection_id) {
        String sql = "DELETE FROM comics WHERE collection_id = ? AND comic_id = ?";
        jdbcTemplate.update(sql, comicId,collection_id);
    }

    @Override
    public void createComic(Comic newComic, int collection_id, int apiID) {
        String sql = "INSERT INTO comics (collection_id, title, volume, issue_number, genre, author, release_date, in_store_date, image, deck, icon_URL, api_ID, description, publisher) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING comic_id";
        jdbcTemplate.update(sql, collection_id, newComic.getTitle(), newComic.getVolume(), newComic.getIssueNumber(), newComic.getGenre(), newComic.getAuthor(), newComic.getReleaseDate(), newComic.getInStoreDate(),
                newComic.getImage(), newComic.getDeck(),newComic.getIconURL(), apiID, newComic.getDescription(), newComic.getPublisher());
    }

    private Comic mapRowToComic(SqlRowSet result){
        Comic comic = new Comic();
        comic.setComicId(result.getInt("comic_id"));
        comic.setCollection_id(result.getInt("collection_id"));
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
