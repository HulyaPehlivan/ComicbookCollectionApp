package com.techelevator.controller;

import com.techelevator.model.Comic;
import com.techelevator.services.ComicVineService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ComicVineController {
    @GetMapping("/comicvine")
    public Comic[] getAllComics() {
        ComicVineService service = new ComicVineService();
        Comic[] allIssues = service.getAllComics();
        //System.out.println(allIssues[0].getTitle());
        return allIssues;
    }
}
