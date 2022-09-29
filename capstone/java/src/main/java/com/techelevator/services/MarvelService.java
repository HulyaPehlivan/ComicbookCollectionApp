//package com.techelevator.services;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.techelevator.model.Comic;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class MarvelService {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String BASE_API_URL = "https://gateway.marvel.com:443/v1/public/";
//    private final String API_KEY = "&apikey=4346314a81fed83ff74a2bb071336d59";
//
//    public List<Comic> getAllComics() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("user-agent", "Request-Promise");
//        HttpEntity entity = new HttpEntity(headers);
//        // need this to get timestamp?? LocalDateTime.now();
//        ResponseEntity<String> response = restTemplate.exchange(BASE_API_URL + "comics/?apikey=" + API_KEY, HttpMethod.GET, entity, String.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        List<Comic> comicList = new ArrayList<>();
//
//        try {
//            JsonNode jsonNode = objectMapper.readTree(response.getBody());
//            JsonNode root = jsonNode.path("results");
//            for (int i = 0; i < root.size(); i++) {
//                int id = root.path(i).path("id").asInt();
//                String title = root.path(i).path("name").asText();
//                int issueNumber = root.path(i).path("issue_number").asInt();
//                Comic comic = new Comic(id, title, issueNumber);
//                comicList.add(comic);
//            }
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return comicList;
//    }
//
////    public Comic getComicById(int id) {
////        HttpHeaders headers = new HttpHeaders();
////        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.set("user-agent", "Request-Promise");
////        HttpEntity entity = new HttpEntity(headers);
////        // need this to get timestamp?? LocalDateTime.now();
////        Comic comic = restTemplate.getForObject(BASE_API_URL + "comics/" + id + "?apikey=" + API_KEY, String.class);
////        ObjectMapper objectMapper = new ObjectMapper();
////
////        Comic comic = null;
////
////        try {
////            JsonNode jsonNode = objectMapper.readTree(response.getBody());
////            JsonNode root = jsonNode.path("results");
////
////        }
////    }
//}
