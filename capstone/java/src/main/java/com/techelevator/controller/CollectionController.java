
package com.techelevator.controller;

import com.techelevator.dao.CollectionDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/collections")
public class CollectionController {

    @Autowired
    private CollectionDAO collectionDAO;
    @Autowired
    private UserDao userDao;

    public CollectionController(CollectionDAO collectionDAO, UserDao userDao) {
        this.collectionDAO = collectionDAO;
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Collection> getAllCollection(){
        List<Collection> collections = collectionDAO.getAllCollection();
        return collections;
    }

    @RequestMapping(path = "/userId", method = RequestMethod.GET)
    public List<Collection> getCollectionByUserId(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        List<Collection> collections = collectionDAO.getCollectionByUserId(userId);
        return collections;
    }

    @RequestMapping(path = "/collectionName/{collectionName}", method = RequestMethod.GET)
    public List<Collection> getCollectionByCollectionName(@PathVariable String collectionName, Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        List<Collection> collections = collectionDAO.getCollectionByCollectionName(collectionName, userId);
        return collections;
    }
    
    @RequestMapping(path = "/public", method = RequestMethod.GET)
    public List<Collection> getAllPublicCollection(){
        List<Collection> collections = collectionDAO.getAllPublicCollection();
        return collections;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void createCollection(@RequestBody Collection newCollection, Principal principal){
       collectionDAO.createCollection(newCollection);
    }

    @RequestMapping(path = "/collectionId/{collectionId}", method = RequestMethod.DELETE)
    public void deleteCollection(@PathVariable int collectionId){
        collectionDAO.deleteCollection(collectionId);
    }

    @RequestMapping(path = "/{collectionId}", method = RequestMethod.GET)
    public List<Collection> getCollectionByCollectionId(@PathVariable int collectionId){
        List<Collection> collections = collectionDAO.getCollectionByCollectionId(collectionId);
        return collections;
    }


}
