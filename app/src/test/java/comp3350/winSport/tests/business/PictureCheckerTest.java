package comp3350.winSport.tests.business;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.business.PictureChecker;

import static org.junit.Assert.assertNotNull;

public class PictureCheckerTest {
    private PictureChecker pictureChecker;

    @Before
    public void setUp(){
        pictureChecker = new PictureChecker();
    }

    @Test
    public void testGetPic(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Pic");
        System.out.print("\n---------------------------------------");
        int pic = pictureChecker.getPic("Winnipeg Jets");
        assertNotNull(pic);
    }
}
