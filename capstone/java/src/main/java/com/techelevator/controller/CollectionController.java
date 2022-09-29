package com.techelevator.controller;

import com.techelevator.dao.CollectionDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collections")
public class CollectionController {
    private CollectionDAO collectionDAO;
    private UserDao userDao;

    public CollectionController(CollectionDAO collectionDAO, UserDao userDao) {
        this.collectionDAO = collectionDAO;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Collection> getAllCollection(){
        List<Collection> collections = collectionDAO.getAllCollection();
        return collections;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public List<Collection> getCollectionByUserId(@PathVariable long userId){
        List<Collection> collections = collectionDAO.getCollectionByUserId(userId);
        return collections;
    }

    @RequestMapping(path = "/{collectionName}", method = RequestMethod.GET)
    public List<Collection> getCollectionByCollectionName(@PathVariable String collectionName){
        List<Collection> collections = collectionDAO.getCollectionByCollectionName(collectionName);
        return collections;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void createCollection(@RequestBody Collection newCollection, Principal principal){
       collectionDAO.createCollection(newCollection);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCollection(@PathVariable long collectionId){
        collectionDAO.deleteCollection(collectionId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Collection> getCollectionByCollectionId(@PathVariable long collectionId){
        List<Collection> collections = collectionDAO.getCollectionByCollectionId(collectionId);
        return collections;
    }
}
