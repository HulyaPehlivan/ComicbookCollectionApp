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
    public void deleteComicFromCollection(int collection_id, int apiID) {
        String sql = "DELETE FROM comics WHERE collection_id = ? AND api_id = ?";
        Integer deleteNo = jdbcTemplate.update(sql, collection_id, apiID);

        if(deleteNo == 1){
            System.out.println(deleteNo);
        } else {
            System.out.println("Delete failed");
        }
    }

    @Override
    public void createComic(Comic newComic, int collection_id, int apiID) {
        String sql = "INSERT INTO comics (collection_id, title, volume, issue_number," +
                " release_date, image, icon_URL, api_ID, description, publisher, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
        jdbcTemplate.update(sql, collection_id, newComic.getTitle(), newComic.getVolume(), newComic.getIssueNumber(), newComic.getReleaseDate(),
                newComic.getImage(),newComic.getIconURL(), apiID, newComic.getDescription(), newComic.getPublisher());
    }

    @Override
    public void updateComicQuantity(Comic comic, int comicId) {
        String sql = "UPDATE comics SET quantity = ? WHERE comic_id = ?";
        Integer updatedNo = jdbcTemplate.update(sql, comic.getQuantity(), comicId);
        if(updatedNo == 1){
            System.out.println(updatedNo);
        } else {
            System.out.println("Update failed");
        }
    }

    @Override
    public Comic getComicByCollectionAndAPIID(int collection_id, int apiID) {
        Comic comic = new Comic();
        String sql = "SELECT * FROM comics WHERE collection_id = ? AND api_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collection_id, apiID);
        if (result.next()){
            comic = mapRowToComic(result);
        }
        return comic;
    }


    private Comic mapRowToComic(SqlRowSet result){
        Comic comic = new Comic();
        comic.setComicId(result.getInt("comic_id"));
        comic.setCollection_id(result.getInt("collection_id"));
        comic.setTitle(result.getString("title"));
        comic.setVolume(result.getString("volume"));
        comic.setIssueNumber(result.getInt("issue_number"));
        comic.setReleaseDate(result.getString("release_date"));
        comic.setImage(result.getString("image"));
        comic.setIconURL(result.getString("icon_URL"));
        comic.setApiID(result.getInt("api_ID"));
        comic.setDescription(result.getString("description"));
        comic.setPublisher(result.getString("publisher"));
        comic.setQuantity(result.getInt("quantity"));
        return comic;
    }
}
