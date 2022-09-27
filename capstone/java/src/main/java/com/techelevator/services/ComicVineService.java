package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Comic;
import com.techelevator.model.ComicResults;
import org.springframework.expression.ParseException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class ComicVineService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String BASE_API_URL = "https://comicvine.gamespot.com/api/";
    private final String API_KEY = "?api_key=5b56f450b870fa8a40b7bcec2786cd1eb06808d1";

    public List<Comic> getAllComics() throws ParseException {
        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("user-agent", "Request-Promise");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(BASE_API_URL + "issues/" + API_KEY + "&format=json", HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Comic> comicList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            JsonNode root = jsonNode.path("results");
            for (int i = 0; i < root.size(); i++){
                int id = root.path(i).path("id").asInt();
                String volume = root.path(i).path("volume").path("name").asText();
                String title = root.path(i).path("name").asText();
                int issueNumber = root.path(i).path("issue_number").asInt();
                String image = root.path(i).path("image").path("small_url").asText();
                Date coverDate = formatter.parse(root.path(i).path("cover_date").asText());
                Comic comic = new Comic(id, title, volume, issueNumber, coverDate, image);
                comicList.add(comic);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return comicList;
    }

    public Comic getSearchedComics(Integer idSearched) throws ParseException {
        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("user-agent", "Request-Promise");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(BASE_API_URL + "issue/4000-"+ idSearched + API_KEY + "&format=json", HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Comic searchedComic = new Comic();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            JsonNode root = jsonNode.path("results");
            for (int i = 0; i < root.size(); i++){
                int id = root.path(i).path("id").asInt();
                String volume = root.path(i).path("volume").path("name").asText();
                String title = root.path(i).path("name").asText();
                int issueNumber = root.path(i).path("issue_number").asInt();
                String image = root.path(i).path("image").path("small_url").asText();
                Date coverDate = formatter.parse(root.path(i).path("cover_date").asText());
                searchedComic = new Comic(id, title, volume, issueNumber, coverDate, image);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return searchedComic;
    }

    /*public Comic[] getAllComics() {
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
    }*/
}
