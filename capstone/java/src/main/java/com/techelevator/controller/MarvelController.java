package com.techelevator.controller;

import com.techelevator.model.Comic;
import com.techelevator.services.ComicVineService;
import com.techelevator.services.MarvelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MarvelController {

    @GetMapping("/marvel")
    public List<Comic> getAllComics() {
        MarvelService service = new MarvelService();
        List<Comic> allComics = service.getAllComics();
        return allComics;
    }

    @GetMapping("/issues/{id}")
    public Comic getComicById(int id) {
        MarvelService service = new MarvelService();
        return null;

    }
}
