package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import comp3350.winSport.business.AccessLocations;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.objects.Location;
import comp3350.winSport.persistence.ILocation;
import comp3350.winSport.persistence.hsqldb.LocationDataHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessLocationsIT {
    private AccessLocations accessLocations;
    private File tempDB;

    @Before
    public void setUp() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final ILocation iLocation = new LocationDataHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        this.accessLocations = new AccessLocations(iLocation);
    }

    @Test
    public void testGetVenues(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Venues");
        System.out.print("\n---------------------------------------");
        final List<Location> venues = accessLocations.getVenues();
        assertNotNull(venues);
        assertEquals(4,venues.size());

        System.out.print("\nFinished test.");
    }

    @Test
    public void testGetValuesData(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Check Get Venues Data");
        System.out.print("\n---------------------------------------");
        final List<Location> venues = accessLocations.getVenues();
        assertNotNull(venues);
        assertEquals(4,venues.size());

        System.out.print("\nIterating through list...");
        ListIterator<Location> iterator = venues.listIterator();
        while(iterator.hasNext()){
            Location location = iterator.next();
            location.validateObject();
            System.out.print("\n");
        }

        System.out.print("\nFinished test.");
    }

    @Test
    public void testGetBars() throws InvalidNameException {
        System.out.print("\n------------------AccessLocations Integration Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 3: Get Bars");
        System.out.print("\n---------------------------------------");
        final List<Location> bars = accessLocations.getBars("MTS center");
        ListIterator<Location> iterator = bars.listIterator();

        System.out.print("\nIterating through list...");
        while (iterator.hasNext()){
            Location location = iterator.next();
            assertNotNull(location);
            location.validateObject();
            System.out.print("\n");
        }

        System.out.print("\nFinished test.");
    }

    @After
    public void tearDown(){
        this.tempDB.delete();
    }
}
