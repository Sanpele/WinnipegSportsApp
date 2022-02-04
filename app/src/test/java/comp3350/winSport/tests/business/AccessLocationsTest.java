package comp3350.winSport.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import comp3350.winSport.business.AccessLocations;
import comp3350.winSport.objects.Location;
import comp3350.winSport.persistence.ILocation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccessLocationsTest {
    private ILocation iLocation;
    private AccessLocations accessLocations;
    private AccessLocations accessLocationsNoMock;

    @Before
    public void setUp(){
        iLocation = mock(ILocation.class);
        accessLocations = new AccessLocations(iLocation);
        accessLocationsNoMock = new AccessLocations();
    }

    @Test
    public void testGetVenues(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Venues");
        System.out.print("\n---------------------------------------");
        final List<Location> dummyList;
        final List<Location> sampleVenues = new ArrayList<>();

        when(iLocation.getSportVenues()).thenReturn(sampleVenues);
        dummyList = accessLocations.getVenues();
        assertNotNull(dummyList);

        verify(iLocation).getSportVenues();

        System.out.print("\nFinished test.");
    }

    @Test
    public void testGetBars(){
        System.out.print("\n------------------AccessLocations Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Get Bars");
        System.out.print("\n---------------------------------------");

        String input1 = "39803498034";
        String input2 = "Neighbourhood 45";
        String input3 = "";
        String input4 = "            ";
        String input5 = "Winnipeg              Neighbour";
        String input6 = " My Neighbour    ";

        System.out.print("\nShould throw an exception if there are numeric characters in the string.\n");

        int counter = 0;

        try{
            System.out.print("\nInput: " + input1);
            accessLocationsNoMock.getBars(input1);
            fail("\nMethod did not throw an exception.\n");
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input2);
            accessLocationsNoMock.getBars(input2);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: (empty)");
            accessLocationsNoMock.getBars(input3);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: (whitespace)");
            accessLocationsNoMock.getBars(input4);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input5);
            accessLocationsNoMock.getBars(input5);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input6);
            accessLocationsNoMock.getBars(input6);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        System.out.print("\n---------------------------------------");
        System.out.print("\nExpected: 6");
        System.out.print("\nExceptions thrown: " + counter);
        System.out.print("\n---------------------------------------");
    }

    @Test
    public void testGetLocation(){
        String input = "A Cool Location";
        Location location = new Location("Cool Location","A very cool place to hangout.", "#22 Cool Ave",120.0,120.0,false);
        when(iLocation.getLocationByName(input)).thenReturn(location);
        accessLocations.getLocationByName(input);
        verify(iLocation).getLocationByName(input);
    }
}
