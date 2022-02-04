package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import comp3350.winSport.business.AccessLocations;
import comp3350.winSport.business.AccessNewsFeed;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.objects.Location;
import comp3350.winSport.objects.NewsPost;
import comp3350.winSport.objects.Team;
import comp3350.winSport.persistence.ILocation;
import comp3350.winSport.persistence.INewsFeed;
import comp3350.winSport.persistence.hsqldb.LocationDataHSQLDB;
import comp3350.winSport.persistence.hsqldb.NewsFeedDataHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

public class AccessNewsFeedIT {

    private AccessNewsFeed accessNewsFeed;
    private File tempDB;

    @Before
    public void setUp() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final INewsFeed iNewsFeed = new NewsFeedDataHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        this.accessNewsFeed = new AccessNewsFeed(iNewsFeed);
    }

    @Test
    public void testGetNewsPosts(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Listing Teams");
        System.out.print("\n---------------------------------------");

        final List<NewsPost> news = accessNewsFeed.getNewsPosts();
        assertNotNull(news);
        assertEquals(3,news.size());

        System.out.print("\nFinished test.");

    }

    @After
    public void tearDown(){
        this.tempDB.delete();
    }
}
