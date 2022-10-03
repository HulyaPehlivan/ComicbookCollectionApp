package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Comic;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ComicVineService {
    private String apiURL = "https://comicvine.gamespot.com/api/";
    private String volumes = "volumes";
    private String volume = "volume/4050-";
    private String issues = "issues";
    private String issue = "issue/4000-";
    private String publisher = "publisher/?";
    private String publishers = "publishers/?";
    private String characters = "characters/?";
    private String keyValue = "/?api_key=58f85d4b1312890c322a1206a4d76a5bd0f68f7f";
    private String filterName = "&format=json&filter=name:";
    private String filterId = "&format=json&filter=id:";
    private String storyArc = "story_arcs";

    private String getVolumes = apiURL + volumes; //+ "?api_key=" + keyValue + "&format=json&filter=name:";
    private String getVolume = apiURL + volume;
    private String getIssues = apiURL + issues + keyValue + "&format=json&filter=name:";
    private String getIssue = apiURL + issue;
    private String getPublishers = apiURL + publishers + "?api_key=" + keyValue + "&format=json&filter=name:";
    private String getCharacters = apiURL + characters + "?api_key=" + keyValue + "&format=json&filter=name:";
    private String getStoryArc = apiURL + storyArc + keyValue + "&format=json&filter=name:";

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<Comic> getAllVolumes() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.exchange(getVolumes + keyValue + "&format=json", HttpMethod.GET, makeHttpEntity(), String.class);
        List<Comic> comicList = new ArrayList<>();

        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(response.getBody());

        JsonNode root = jsonNode.path("results");

        for (int i = 0; i < root.size(); i++) {
            int apiID = root.path(i).path("id").asInt();
            String title = root.path(i).path("name").asText();
            String imageURL = root.path(i).path("image").path("original_url").asText();
            String iconURL = root.path(i).path("image").path("icon_url").asText();
            String deck = root.path(i).path("deck").asText();
            String publisher = root.path(i).path("publisher").path("name").asText();
            String description = root.path(i).path("description").asText();
            String releaseDate = root.path(i).path("cover_date").asText();
            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher);
            comicList.add(comic);
        }
        return comicList;
    }

    public List<Comic> getAllComics() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.exchange(getIssues, HttpMethod.GET, makeHttpEntity(), String.class);
        List<Comic> comicList = new ArrayList<>();

        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(response.getBody());

        JsonNode root = jsonNode.path("results");

        for (int i = 0; i < root.size(); i++) {
            int apiID = root.path(i).path("id").asInt();
            String title = root.path(i).path("name").asText();
            String imageURL = root.path(i).path("image").path("original_url").asText();
            String deck = root.path(i).path("deck").asText();
            String description = root.path(i).path("description").asText();
            String coverDate = root.path(i).path("cover_date").asText();
            Comic comic = new Comic(title, coverDate, imageURL, deck, apiID, description);
            comicList.add(comic);
        }
        return comicList;
    }

    public List<Comic> getComicByVolumeID(int searchID) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.exchange(getVolume + searchID + keyValue + "&format=json", HttpMethod.GET, makeHttpEntity(), String.class);
        List<Comic> comicList = new ArrayList<>();

        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(response.getBody());

        JsonNode root = jsonNode.path("results");

        for (int i = 0; i < root.size(); i++) {
            int apiID = root.path(i).path("id").asInt();
            String title = root.path(i).path("name").asText();
            String imageURL = root.path(i).path("image").path("original_url").asText();
            String iconURL = root.path(i).path("image").path("icon_url").asText();
            String deck = root.path(i).path("deck").asText();
            String publisher = root.path(i).path("publisher").path("name").asText();
            String description = root.path(i).path("description").asText();
            String releaseDate = root.path(i).path("cover_date").asText();
            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher);
            comicList.add(comic);
        }

        return comicList;
    }

    public Comic getComicByIssueID(int searchID) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.exchange(getIssue + searchID + keyValue + "&format=json", HttpMethod.GET, makeHttpEntity(), String.class);

        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(response.getBody());

        JsonNode root = jsonNode.path("results");
        int apiID = root.path("id").asInt();
        String title = root.path("name").asText();
        String imageURL = root.path("image").path("original_url").asText();
        String iconURL = root.path("image").path("icon_url").asText();
        String deck = root.path("deck").asText();
        int issue = root.path("issue_number").asInt();
        String description = root.path("description").asText();
        String volumeName = root.path("volume").path("name").asText();
        String releaseDate = root.path("cover_date").asText();

        int volumeId = root.path("volume").path("id").asInt();
        ResponseEntity<String> responseVolumes = restTemplate.exchange(getVolume + volumeId + keyValue + "&format=json", HttpMethod.GET, makeHttpEntity(), String.class);
        JsonNode jsonNodeVolume;
        jsonNodeVolume = objectMapper.readTree(responseVolumes.getBody());

        JsonNode rootVolume = jsonNodeVolume.path("results");
        String publisher = rootVolume.path("publisher").path("name").asText();
        Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher, volumeName);

        return comic;
    }

    public List<Comic> getComicListByTitle(String titles) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.exchange(getIssues + titles, HttpMethod.GET, makeHttpEntity(), String.class);
        List<Comic> comicList = new ArrayList<>();
        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(response.getBody());

        JsonNode root = jsonNode.path("results");

        for (int i = 0; i < root.size(); i++) {
            int apiID = root.path(i).path("id").asInt();
            String title = root.path(i).path("name").asText();
            String imageURL = root.path(i).path("image").path("original_url").asText();
            String iconURL = root.path(i).path("image").path("icon_url").asText();
            String deck = root.path(i).path("deck").asText();
            int issue = root.path(i).path("issue_number").asInt();
            String description = root.path(i).path("description").asText();
            String volumeName = root.path(i).path("volume").path("name").asText();
            String releaseDate = root.path(i).path("cover_date").asText();

            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, "", volumeName);
            comicList.add(comic);
        }
        return comicList;
    }

    private HttpEntity makeHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("user-agent", "Mozilla/5.0 Firefox/26.0");
        HttpEntity<String> httpEntity = new HttpEntity(httpHeaders);
        return httpEntity;
    }


//    public List<Comic> getComicListByStoryArc(String storyArcs) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange(getStoryArc + storyArcs , HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//        JsonNode jsonNode;
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results");
//
//        for (int i = 0; i < root.size(); i++) {
//            int apiID = root.path(i).path("id").asInt();
//            String title = root.path(i).path("name").asText();
//            String imageURL = root.path(i).path("image").path("original_url").asText();
//            String iconURL = root.path(i).path("image").path("icon_url").asText();
//            String deck = root.path(i).path("deck").asText();
//            int issue = root.path(i).path("issue_number").asInt();
//            String description = root.path(i).path("description").asText();
//            String volumeName = root.path(i).path("volume").path("name").asText();
//            String releaseDate = root.path(i).path("cover_date").asText();
//            String publisher = root.path(i).path("publisher").path("name").asText();
//            String storyArc = root.path(i).path("storyArcs").path("name").asText(); //needs adjusted
//            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher, volumeName);
//            comicList.add(comic);
//        }
//        return comicList;
//    }
//
//    public List<Comic> getComicsListByIssue(String searchString) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange(getIssues + searchString, HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//
//        JsonNode jsonNode;
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results");
//
//        for (int i = 0; i < root.size(); i++) {
//            int apiID = root.path(i).path("id").asInt();
//            String title = root.path(i).path("name").asText();
//            String imageURL = root.path(i).path("image").path("original_url").asText();
//            String iconURL = root.path(i).path("image").path("icon_url").asText();
//            String deck = root.path(i).path("deck").asText();
//            int issue = root.path(i).path("issue_number").asInt();
//            String description = root.path(i).path("description").asText();
//            String volumeName = root.path(i).path("volume").path("name").asText();
//            String releaseDate = root.path(i).path("cover_date").asText();
//            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, "", volumeName);
//            comicList.add(comic);
//        }
//        return comicList;
//    }
//
//    public List<Comic> getComicsListByCharacter(String searchString) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange(getCharacters + searchString, HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//
//        JsonNode jsonNode;
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results");
//
//        for (int i = 0; i < root.size(); i++) {
//            int apiID = root.path(i).path("id").asInt();
//            String title = root.path(i).path("name").asText();
//            String imageURL = root.path(i).path("image").path("original_url").asText();
//            String iconURL = root.path(i).path("image").path("icon_url").asText();
//            String deck = root.path(i).path("deck").asText();
//            String description = root.path(i).path("description").asText();
//            String publisher = root.path(i).path("publisher").path("name").asText();
//            String releaseDate = root.path(i).path("cover_date").asText();
//            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher);
//            comicList.add(comic);
//        }
//
//        return comicList;
//    }
//
//    public List<Comic> getVolumesListByCharacterID(int searchID) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange("https://comicvine.gamespot.com/api/character/4005-" +
//                searchID + "/?api_key=58f85d4b1312890c322a1206a4d76a5bd0f68f7f&format=json&field_list=issue_credits", HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//
//        JsonNode jsonNode;
//
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results").path("issue_credits");
//
//        System.out.println("ID: ");
//
//        for (int j = 0; j < root.size(); j++)
//        {
//            System.out.println("ID: " + root.path(j).path("id").asInt());
//            comicList.add(getComicByIssueID(root.path(j).path("id").asInt()));
//        }
//        return comicList;
//    }
//
//    public List<Comic> getIssuesListByPublisherID(int searchID) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange(apiURL + "publisher/" +
//                searchID + "/?api_key=" + keyValue + "&format=json&field_list=volumes&limit=5", HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//        List<Integer> idList = new ArrayList<>();
//
//        JsonNode jsonNode;
//
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results").path("volumes");
//
//        // 1. don't extract all of these, only extract the volume ID and put that volumeID into a list of String.
//        for (int i = 0; i < root.size(); i++) {
//            Integer volumeId = root.path(i).path("id").asInt();
//            idList.add(volumeId);
//        }
//
//        //2. Iterate through the list, and call your other api endpoint.
//
//        for (int i = 0; i < idList.size(); i++){
//
//            Comic comic = getComicByVolumeID(idList.get(i)).get(0);
//            comicList.add(comic);
//        }
//
//        return comicList;
//    }
//
//    public List<Comic> getComicsListByPublisher(String searchString) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange(getPublishers + searchString, HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//
//        JsonNode jsonNode;
//
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results");
//
//        for (int i = 0; i < root.size(); i++) {
//            int apiID = root.path(i).path("id").asInt();
//            String title = root.path(i).path("name").asText();
//            String imageURL = root.path(i).path("image").path("original_url").asText();
//            String iconURL = root.path(i).path("image").path("icon_url").asText();
//            String deck = root.path(i).path("deck").asText();
//            String description = root.path(i).path("description").asText();
//            String publisher = root.path(i).path("publisher").path("name").asText();
//            String releaseDate = root.path(i).path("cover_date").asText();
//            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher);
//            comicList.add(comic);
//        }
//
//        return comicList;
//    }
//
//    public List<Comic> getComicsListByVolume(String searchString) throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.exchange(getVolumes + searchString, HttpMethod.GET, makeHttpEntity(), String.class);
//        List<Comic> comicList = new ArrayList<>();
//
//        JsonNode jsonNode;
//        jsonNode = objectMapper.readTree(response.getBody());
//
//        JsonNode root = jsonNode.path("results");
//
//        for (int i = 0; i < root.size(); i++) {
//            int apiID = root.path(i).path("id").asInt();
//            String title = root.path(i).path("name").asText();
//            String imageURL = root.path(i).path("image").path("original_url").asText();
//            String iconURL = root.path(i).path("image").path("icon_url").asText();
//            String deck = root.path(i).path("deck").asText();
//            String description = root.path(i).path("description").asText();
//            String publisher = root.path(i).path("publisher").path("name").asText();
//            String releaseDate = root.path(i).path("cover_date").asText();
//            Comic comic = new Comic(title, releaseDate, imageURL, deck, iconURL, apiID, description, publisher);
//            comicList.add(comic);
//        }
//
//        return comicList;
//    }
}