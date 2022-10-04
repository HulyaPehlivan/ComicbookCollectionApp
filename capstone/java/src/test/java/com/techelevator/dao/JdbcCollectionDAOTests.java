package com.techelevator.dao;

import com.techelevator.model.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcCollectionDAOTests extends BaseDaoTests {

    private static final Collection COLLECTION_1 = new Collection(1, "My Collection 1", 1, true );
    private static final Collection COLLECTION_2 = new Collection(2,"My Collection 2", 2, false);
    private static final Collection COLLECTION_3 = new Collection(3, "My Collection 3", 1, true);

    private Collection testCollection;

    private JdbcCollectionDAO sut;

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcCollectionDAO(jdbcTemplate);
        testCollection = new Collection(0, "Test Collection", 9,false);
    }

    @Test
    public void getCollection_returns_all_collection(){
        List<Collection> collections = sut.getAllCollection();
        Assert.assertEquals(3,collections.size());

        assertCollectionsMatch(COLLECTION_1, collections.get(0));
        assertCollectionsMatch(COLLECTION_2, collections.get(1));
        assertCollectionsMatch(COLLECTION_3, collections.get(2));
    }

    @Test
    public void getCollection_returns_correct_collection_for_user_id(){
        List<Collection> collection = sut.getCollectionByUserId(1);
        Assert.assertEquals(2, collection.size());

        assertCollectionsMatch(COLLECTION_1, collection.get(0));
        assertCollectionsMatch(COLLECTION_3, collection.get(2));
    }

    @Test
    public void getCollection_returns_correct_collection_for_collection_name(){
        List<Collection> collection = sut.getCollectionByCollectionName("My Collection 1", 1);
        Assert.assertEquals(1, collection.size());

        assertCollectionsMatch(COLLECTION_1, collection.get(0));
    }
    @Test
    public void getCollection_returns_correct_collection_for_public(){
        List<Collection> collection = sut.getAllPublicCollection();
        boolean result = COLLECTION_1.isPublic();
        Assert.assertTrue(result);
    }

    @Test
    public void createCollection_returns_collection_id_with_expected_values(){
        Collection newCollection = sut.createCollection(testCollection, 1);
        Integer newId = newCollection.getCollectionId();
        Assert.assertTrue(newId > 0);

        testCollection.setCollectionId(newId);
        assertCollectionsMatch(testCollection, newCollection);
    }

    @Test
    public void delete_Collection_cant_be_retrieved(){
        sut.deleteCollection(4);

        List<Collection> retrievedCollection = sut.getCollectionByCollectionId(4);
        Assert.assertNull(retrievedCollection);

        List<Collection> collections = sut.getCollectionByUserId(4);
        Assert.assertEquals(1, collections.size());
        assertCollectionsMatch(COLLECTION_1, collections.get(0));

    }

    @Test
    public void getCollection_returns_correct_collection_for_collection_id(){
        List<Collection> collection = sut.getCollectionByCollectionId(1);
        Assert.assertEquals(1, collection.size());

        assertCollectionsMatch(COLLECTION_1, collection.get(0));
    }

    @Test
    public void update_collection_has_expected_values_when_retrieved(){
        List<Collection> collectionToUpdate = sut.getCollectionByCollectionId(1);
        Assert.assertEquals(1, collectionToUpdate.size());

        assertCollectionsMatch(COLLECTION_1, collectionToUpdate.get(0));
        collectionToUpdate.get(0).setCollectionName("updated");
        collectionToUpdate.get(0).setUserId(2);
        collectionToUpdate.get(0).isPublic();

        List<Collection> retrievedCollection = sut.getCollectionByCollectionId(1);
        assertCollectionsMatch(collectionToUpdate.get(0), retrievedCollection.get(0));

    }

    private void assertCollectionsMatch(Collection expected, Collection actual){
        Assert.assertEquals(expected.getCollectionId(), actual.getCollectionId());
        Assert.assertEquals(expected.getCollectionName(), actual.getCollectionName());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.isPublic(), actual.isPublic());
    }

}
