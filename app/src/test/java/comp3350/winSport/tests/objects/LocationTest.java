package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Location;

import static org.junit.Assert.assertNotNull;

public class LocationTest {
    private Location location;

    @Before
    public void setUp(){
        location = new Location("Very Prosperous City", "A city that people live in.", "204 Very Impressionable Address", 123.4,456.7,true);
        assertNotNull(location);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Location Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating Location Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        location.validateObject();
    }
}
