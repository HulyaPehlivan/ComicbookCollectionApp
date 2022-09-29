package com.techelevator.controller;

import com.techelevator.model.Comic;
import com.techelevator.services.ComicVineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ComicVineController {

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
}
