package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import comp3350.winSport.business.AccessComments;
import comp3350.winSport.objects.Comment;
import comp3350.winSport.persistence.IComments;
import comp3350.winSport.persistence.hsqldb.CommentsHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;

public class AccessCommentsIT {
    private AccessComments accessComments;
    private File tempDB;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final IComments iComments = new CommentsHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        this.accessComments = new AccessComments(iComments);
    }

    @Test
    public void testGetComments(){
        final List<Comment> comments = accessComments.getComments(1);
        assertNotNull(comments);

        ListIterator<Comment>iterator = comments.listIterator();
        while (iterator.hasNext()){
            Comment comment = iterator.next();
            assertNotNull(comment);
            comment.validateObject();
            System.out.print("\n");
        }
    }

    @After
    public void tearDown(){
        this.tempDB.delete();
    }

}
