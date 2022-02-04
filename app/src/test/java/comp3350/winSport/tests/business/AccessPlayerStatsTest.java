package comp3350.winSport.tests.business;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.business.AccessPlayerStats;
import comp3350.winSport.objects.PlayerStatistic;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayerStats;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccessPlayerStatsTest {

    private AccessPlayerStats accessPlayerStats;
    private IPlayerStats iPlayerStats;
    private AccessPlayerStats accessPlayerStatsNoMock;

    @Before
    public void setUp(){
        iPlayerStats = mock(IPlayerStats.class);
        accessPlayerStats = new AccessPlayerStats(iPlayerStats);
        accessPlayerStatsNoMock = new AccessPlayerStats();
    }

    @Test
    public void testPlayerStatsName1() throws InvalidNameException {
        System.out.print("\n------------------AccessPlayerStats Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Players Stats - Behaviour");
        System.out.print("\n---------------------------------------");

        final PlayerStatistic playerStatistic;
        final PlayerStatistic samplePlayer = new PlayerStatistic();

        when(iPlayerStats.getPlayerByName("Mark Scheifele")).thenReturn(samplePlayer);
        playerStatistic = accessPlayerStats.getPlayerByName("Mark Scheifele");
        assertNotNull(playerStatistic);

        verify(iPlayerStats).getPlayerByName("Mark Scheifele");

        System.out.print("\nFinished test.");
    }

    @Test
    public void testPlayerStatsName2(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Get Player Stats - Errors");
        System.out.print("\n---------------------------------------");

        String input1 = "39803498034";
        String input2 = "Mark Scheifele 45";
        String input3 = "";
        String input4 = "            ";
        String input5 = "Mark              Scheifele";
        String input6 = " Mark Scheifele    ";

        int counter = 0;

        try{
            System.out.print("\nInput: " + input1);
            accessPlayerStatsNoMock.getPlayerByName(input1);
            fail("\nMethod did not throw an exception.\n");
        }
        catch (Exception e){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input2);
            accessPlayerStatsNoMock.getPlayerByName(input2);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception e){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: (empty)");
            accessPlayerStatsNoMock.getPlayerByName(input3);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception e){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: (whitespace)");
            accessPlayerStatsNoMock.getPlayerByName(input4);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception e){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input5);
            accessPlayerStatsNoMock.getPlayerByName(input5);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception e){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        try{
            System.out.print("\nInput: " + input6);
            accessPlayerStatsNoMock.getPlayerByName(input6);
            fail("\nMethod did not throw an exception\n");
        }
        catch (Exception e){
            System.out.print("\nMethod threw an exception.\n");
            counter++;
        }

        System.out.print("\n---------------------------------------");
        System.out.print("\nExpected: 6");
        System.out.print("\nExceptions thrown: " + counter);
        System.out.print("\n---------------------------------------");
    }

}
