package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Standing;

import static org.junit.Assert.assertNotNull;

public class StandingTest {
    private Standing standing;

    @Before
    public void setUp(){
        standing = new Standing(1, "Kryptonian Polar Bears", 5,1,1,20,"Pretty Good Win Streak");
        assertNotNull(standing);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Standing Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating Standing Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        standing.validateObject();
    }
}
