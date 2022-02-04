package comp3350.winSport.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.business.AccessNewsFeed;
import comp3350.winSport.objects.NewsPost;
import comp3350.winSport.persistence.INewsFeed;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccessNewsFeedTest {
    private INewsFeed iNewsFeed;
    private AccessNewsFeed accessNewsFeed;
    private NewsPost newsPost;

    @Before
    public void setUp(){
        iNewsFeed = mock(INewsFeed.class);
        accessNewsFeed = new AccessNewsFeed(iNewsFeed);
        newsPost = new NewsPost(1, "Very Controversial Sports Headline", "12/31/1999", "Two top teams in a bitter feud.", 10, 3, 5);
    }

    @Test
    public void testGetNewsPosts(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get NewsPosts");
        System.out.print("\n---------------------------------------");
        final List<NewsPost> dummyList;
        final List<NewsPost> sampleNewsPosts = new ArrayList<>();

        when(iNewsFeed.getNewsPosts()).thenReturn(sampleNewsPosts);

        dummyList = accessNewsFeed.getNewsPosts();
        assertNotNull(dummyList);

        verify(iNewsFeed).getNewsPosts();

        System.out.print("\nFinished test.");
    }

    @Test
    public void testUpdateLike(){
        System.out.print("\n------------------AccessNewsFeed Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Behaviour -- Update Like");
        System.out.print("\n---------------------------------------");
        accessNewsFeed.updateLike(newsPost);
        verify(iNewsFeed).updateLike(newsPost.getPostID(),newsPost.getLikes());
        System.out.print("\nFinished test.");
    }

    @Test
    public void testUpdateDisLike(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 3: Behaviour -- Update Dislike");
        System.out.print("\n---------------------------------------");
        accessNewsFeed.updateDislike(newsPost);
        verify(iNewsFeed).updateDislike(newsPost.getPostID(),newsPost.getDislikes());
        System.out.print("\nFinished test.");
    }
}
