package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.NewsPost;

import static org.junit.Assert.assertNotNull;

public class NewsPostTest {
    private NewsPost newsPost;

    @Before
    public void setUp(){
        newsPost = new NewsPost(1, "Very Controversial Sports Headline", "12/31/1999", "Two top teams in a bitter feud.", 10, 3, 5);
        assertNotNull(newsPost);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------News Post Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating News Post Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        newsPost.validateObject();
    }
}
