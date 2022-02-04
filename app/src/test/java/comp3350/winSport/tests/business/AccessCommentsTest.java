package comp3350.winSport.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import comp3350.winSport.business.AccessComments;
import comp3350.winSport.objects.Comment;
import comp3350.winSport.persistence.IComments;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccessCommentsTest {
    private IComments iComments;
    private AccessComments accessComments;

    @Before
    public void setUp(){
        iComments = mock(IComments.class);
        accessComments = new AccessComments(iComments);
    }

    @Test
    public void testAddComment(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Adding Comment");
        System.out.print("\n---------------------------------------");
        Comment comment = new Comment();
        accessComments.addComment(comment);
        verify(iComments).insertComment(comment);
        System.out.print("\nFinished test.");
    }

    @Test
    public void testGetComments(){
        System.out.print("\n------------------AccessComments Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Get Comments");
        System.out.print("\n---------------------------------------");
        final List<Comment> dummyList;
        final List<Comment> sampleComments = new ArrayList<>();

        when(iComments.getComments(1)).thenReturn(sampleComments);
        dummyList = accessComments.getComments(1);
        assertNotNull(dummyList);

        verify(iComments).getComments(1);
        System.out.print("\nFinished test.");
    }
}
