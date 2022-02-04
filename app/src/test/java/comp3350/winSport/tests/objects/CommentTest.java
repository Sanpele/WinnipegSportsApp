package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Comment;

import static org.junit.Assert.assertNotNull;

public class CommentTest {
    private Comment comment;

    @Before
    public void setUp(){
        comment = new Comment(1,"A Good Comment Subject Header", "Hello, this is a comment.");
        assertNotNull(comment);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Comment Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating Comment Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        comment.validateObject();
    }
}
