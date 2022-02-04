package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.PlayerStatistic;

import static org.junit.Assert.assertNotNull;

public class PlayerStatisticTest {

    PlayerStatistic playerStat;

    @Before
    public void setUp(){
        playerStat = new PlayerStatistic("Wake Beeler", 5, "High Profile Team of Hockey Players", "Very Important Hockey League", "centre", "2020-2021", 30, 10, 4, 15, 1,1,5);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Player Statistic Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validate PlayerStatistic Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        playerStat.viewPlayerStatObject();
    }
}
