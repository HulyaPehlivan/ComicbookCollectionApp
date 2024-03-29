//package com.techelevator.dao;
//
//import com.techelevator.model.Comic;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//public class JdbcComicDAOTest extends BaseDaoTests{
//
//    private static final Comic COMIC_1 = new Comic("test title","11/11/1111", "test.png", "http", 999, "test description", "test marvel", "test volume");
//    private static final Comic COMIC_2 = new Comic("test title 2","12/11/1111", "test2.png",  "http2", 998, "test description 2", "test marvel", "test volume 2");
//    private static final Comic COMIC_3 = new Comic("test title 3","13/11/1111", "test3.png",  "http3", 997, "test description 3", "test DC", "test volume 3");
//
//    private Comic testComic;
//
//    private JdbcComicDAO sut;
//
//    @Before
//    public void setup() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        sut = new JdbcComicDAO(jdbcTemplate);
//        testComic = new Comic("test comic", "11/12/1234", "img.png", 123, "test description");
//    }
//        @Test
//        public void getComics_returns_all_comics(){
//            List<Comic> comics = sut.getAllComics();
//            Assert.assertEquals(3, comics.size());
//
//            assertComicsMatch(COMIC_1, comics.get(0));
//            assertComicsMatch(COMIC_2, comics.get(1));
//            assertComicsMatch(COMIC_3, comics.get(2));
//        }
//
//        @Test
//        public void getComics_returns_correct_comic_for_comic_id(){
//        Comic comic = sut.getComicByComicId(1);
//        Assert.assertEquals(COMIC_1, comic);
//        }
//
//        @Test
//        public void getComics_returns_correct_comic_for_comic_title(){
//        List<Comic> comic = sut.getComicsByTitle("test title");
//        Assert.assertEquals(1, comic.size());
//
//        assertComicsMatch(COMIC_1, comic.get(0));
//        }
//
//        @Test
//        public void getComics_returns_correct_comic_for_comic_volume(){
//            List<Comic> comic = sut.getComicsByVolume("test volume");
//            Assert.assertEquals(1, comic.size());
//
//            assertComicsMatch(COMIC_1, comic.get(0));
//        }
//
//        @Test
//        public void getComics_returns_correct_comic_for_collection_id(){
//            List<Comic> comic = sut.getComicsByCollectionId(1);
//            Assert.assertEquals(1, comic.size());
//
//            assertComicsMatch(COMIC_1, comic.get(0));
//        }
//
//        @Test
//        public void getComics_returns_correct_for_collection_id_and_api_id(){
//            Comic comic = sut.getComicByCollectionAndAPIID(1, 123);
//            Assert.assertEquals(COMIC_1, comic);
//        }
//
//        @Test
//        public void delete_comics_from_collection_with_collection_id_and_api_id(){
//            sut.deleteComicFromCollection(1, 123);
//
//            List<Comic> retrievedComic = sut.getComicsByCollectionId(1);
//            Assert.assertNull(retrievedComic);
//
//            Comic comic  = sut.getComicByCollectionAndAPIID(1, 123);
//            Assert.assertEquals(COMIC_1, comic);
//            assertComicsMatch(COMIC_1, comic);
//        }
//
//        @Test
//        public void create_comic_returns_all_expected_values(){
//        Comic newComic = sut.createComic(testComic, 1, 123);
//        Integer newId = newComic.getComicId();
//        Assert.assertTrue(newId > 0);
//
//        testComic.setComicId(newId);
//        assertComicsMatch(testComic, newComic);
//        }
//
////        @Test
////        public void update_comic_for_quantity(){
////            List<Comic> updateComicQuantity = sut.
////        }
//
//
//
//        private void assertComicsMatch(Comic expected, Comic actual){
//        Assert.assertEquals(expected.getTitle(), actual.getTitle());
//        Assert.assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
//        Assert.assertEquals(expected.getImage(), actual.getImage());
//        Assert.assertEquals(expected.getApiID(), actual.getApiID());
//        Assert.assertEquals(expected.getIconURL(),  actual.getIconURL());
//        Assert.assertEquals(expected.getDescription(), actual.getDescription());
//        Assert.assertEquals(expected.getPublisher(), actual.getPublisher());
//        Assert.assertEquals(expected.getVolume(), actual.getVolume());
//        }
//
//    }
