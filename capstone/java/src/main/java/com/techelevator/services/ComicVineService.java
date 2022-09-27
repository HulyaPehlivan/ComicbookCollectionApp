package com.techelevator.services;

import com.techelevator.model.Comic;
import com.techelevator.model.ComicResults;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ComicVineService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://comicvine.gamespot.com/api/issues/?api_key=5b56f450b870fa8a40b7bcec2786cd1eb06808d1&format=json";

    public Comic[] getAllComics() {
//        Comic[] allIssues = restTemplate.getForObject(API_URL, Comic[].class);
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("user-agent", "Request-Promise");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<ComicResults> results = restTemplate.exchange("https://comicvine.gamespot.com/api/issues/?api_key=5b56f450b870fa8a40b7bcec2786cd1eb06808d1&format=json",
                HttpMethod.GET, entity,  ComicResults.class);
        Comic[] comics = results.getBody().getResults();
        //String response = restTemplate.getForObject(API_URL, String.class);
        return comics;
    }
}
