package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.Comic;
import com.techelevator.services.ComicVineService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ComicController {

    @GetMapping("/comicvine")
    public List<Comic> getAllComics() {
        ComicVineService service = new ComicVineService();
        List<Comic> allIssues = null; //service.getAllComics();
        return allIssues;
    }

//    @GetMapping("/issues/{id}")
//    public Comic getSearchedComics(Integer idSearched) {
//        ComicVineService service = new ComicVineService();
//        Comic search = null;//service.getSearchedComics(idSearched);
//        return search;
//
//    }

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

    @RequestMapping(path = "/comics", method = RequestMethod.GET)
    public List<Comic> getComics() throws JsonProcessingException {
        List<Comic> comics = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comics = service.getAllComics();
        return comics;
    }

//    @RequestMapping(path = "/issues/{searchString}", method = RequestMethod.GET)
//    public List<Comic> getComicsListByIssue(@PathVariable String searchString) throws JsonProcessingException {
//        List<Comic> comics = new ArrayList<>();
//        ComicVineService service = new ComicVineService();
//        comics = service.getComicsListByIssue(searchString);
//        return comics;
//    }



    @RequestMapping(path = "/issues/{id}", method = RequestMethod.GET)
    public Comic getComicByIssueID(@PathVariable int id) throws JsonProcessingException {
        Comic comics = new Comic();
        ComicVineService service = new ComicVineService();
        comics =  service.getComicByIssueID(id);
        return comics;
    }

}