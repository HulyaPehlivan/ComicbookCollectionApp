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

    @GetMapping("/issues/{id}")
    public Comic getSearchedComics(Integer idSearched) {
        ComicVineService service = new ComicVineService();
        Comic search = null;//service.getSearchedComics(idSearched);
        return search;

    }

    @RequestMapping(path = "/volume/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Comic> getComicsByVolumeID(int searchID) throws JsonProcessingException {
        List<Comic> comics = new ArrayList<>();
        ComicVineService service = new ComicVineService();
        comics = service.getComicByVolumeID(searchID);
        return comics;
    }
}