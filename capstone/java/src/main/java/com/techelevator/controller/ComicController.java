package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.dao.ComicDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Comic;
import com.techelevator.services.ComicVineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
//@RequestMapping(value = "/comicvine")
public class ComicController {
@Autowired
    private ComicDAO comicDAO;
@Autowired
    private UserDao userDao;

    public ComicController(ComicDAO comicDAO, UserDao userDao) {
        this.comicDAO = comicDAO;
        this.userDao = userDao;
    }

    /**
     * !!!!!!!!!!!!!!!!!!!!!
     * jdbcComicDAO Methods
     * !!!!!!!!!!!!!!!!!!!!
     * */

    @RequestMapping(path = "/comics", method = RequestMethod.GET)
    public List<Comic> getAllComics(){
        List<Comic> comics = comicDAO.getAllComics();
        return comics;
    }

    @RequestMapping(path = "/comics/comicId/{comicId}", method = RequestMethod.GET)
    public Comic getComicByComicId(@PathVariable int comicId){
        Comic comic = comicDAO.getComicByComicId(comicId);
        return comic;
    }

    @RequestMapping(path = "/comics/title/{title}", method = RequestMethod.GET)
    public List<Comic> getComicByTitle(@PathVariable String title){
        List<Comic> comicList = comicDAO.getComicsByTitle(title);
        return comicList;
    }

    @RequestMapping(path = "/comics/genre", method = RequestMethod.GET)
    public List<Comic> getComicByGenre (@PathVariable String genre){
        List<Comic> comics = comicDAO.getComicsByGenre(genre);
        return comics;
    }

    @RequestMapping(path = "/comics/author", method = RequestMethod.GET)
    public List<Comic> getComicByAuthor (@PathVariable String author){
        List<Comic> comics = comicDAO.getComicsByAuthor(author);
        return comics;
    }

    @RequestMapping(path = "/comics/volume", method = RequestMethod.GET)
    public List<Comic> getComicByVolume(@PathVariable String volume){
        List<Comic> comics = comicDAO.getComicsByVolume(volume);
        return comics;
    }

    @RequestMapping(path = "/comics/collectionId/{collection_id}", method = RequestMethod.GET)
    public List<Comic> getComicsByCollectionId (@PathVariable int collection_id){
        List<Comic> comics = comicDAO.getComicsByCollectionId(collection_id);
        return comics;
    }

    @RequestMapping(path = "/{collection_id}/add/{apiID}", method = RequestMethod.POST)
    public void addComicIntoCollection(@RequestBody Comic newComic, @PathVariable int collection_id , @PathVariable int apiID){
        comicDAO.createComic(newComic, collection_id, apiID);   ////????????????????????????????
    }

    @RequestMapping(path = "/comics/update/{comic_id}", method = RequestMethod.PUT)
    public void increaseComicQuantity(@PathVariable int comicId) {
        comicDAO.increaseComicQuantity(comicId);
    }

    @RequestMapping(path = "/comics/decrease/{comic_id}", method = RequestMethod.PUT)
    public void decreaseComicQuantity(@PathVariable int comicId) {
        comicDAO.decreaseComicQuantity(comicId);
    }


    /**
     * !!!!!!!!!!!!!!!!!!!!!!!!!!
     * ComicVine Service Methods
     * !!!!!!!!!!!!!!!!!!!!!!!!!
     * */

    @RequestMapping(path = "/volume/{id}", method = RequestMethod.GET)
    public List<Comic> getComicsByVolumeID(@PathVariable int id) throws JsonProcessingException {
        List<Comic> comics = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comics = service.getComicByVolumeID(id);
        return comics;
    }

    @RequestMapping(path = "/volumes", method = RequestMethod.GET)
    public List<Comic> getAllVolumes() throws JsonProcessingException {
        List<Comic> comics = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comics = service.getAllVolumes();
        return comics;
    }

    @RequestMapping(path = "/comicvine/comics", method = RequestMethod.GET)
    public List<Comic> getAllComicsOnline() throws JsonProcessingException {
        List<Comic> comics = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comics = service.getAllComics();
        return comics;
    }

    @RequestMapping(path = "/issues/{id}", method = RequestMethod.GET)
    public Comic getComicByIssueID(@PathVariable int id) throws JsonProcessingException {
        Comic comics = new Comic();
        ComicVineService service = new ComicVineService();
        comics =  service.getComicByIssueID(id);
        return comics;
    }

    @RequestMapping(path = "/comicvine/title/{name}", method = RequestMethod.GET)
    public List<Comic> getComicListByTitle(@PathVariable String name) throws JsonProcessingException {
        List<Comic> comicList = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comicList =  service.getComicListByTitle(name);
        return comicList;
    }
    @RequestMapping(path = "/story_arcs/{name}", method = RequestMethod.GET)
    public List<Comic> getComicListByStoryArc(@PathVariable String name) throws JsonProcessingException {
        List<Comic> comicList = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comicList =  service.getComicListByStoryArc(name);
        return comicList;
    }

    //    @RequestMapping(path = "/issues/{searchString}", method = RequestMethod.GET)
//    public List<Comic> getComicsListByIssue(@PathVariable String searchString) throws JsonProcessingException {
//        List<Comic> comics = new ArrayList<>();
//        ComicVineService service = new ComicVineService();
//        comics = service.getComicsListByIssue(searchString);
//        return comics;
//    }



}