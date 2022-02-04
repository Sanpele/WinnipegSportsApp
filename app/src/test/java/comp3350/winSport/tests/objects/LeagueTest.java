package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.League;

import static org.junit.Assert.assertNotNull;


public class LeagueTest {
    private League league;

    @Before
    public void setUp(){
        league = new League(1,"Very Popular Sports League");
        assertNotNull(league);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------League Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating League Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        league.viewLeagueObject();
    }
}
