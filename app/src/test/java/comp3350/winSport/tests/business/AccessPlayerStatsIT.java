package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import comp3350.winSport.business.AccessPlayerStats;
import comp3350.winSport.objects.PlayerStatistic;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayerStats;
import comp3350.winSport.persistence.hsqldb.PlayerStatsHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;

public class AccessPlayerStatsIT {

    private AccessPlayerStats accessPlayerStats;
    private File tempDB;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final IPlayerStats iPlayerStats = new PlayerStatsHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessPlayerStats = new AccessPlayerStats(iPlayerStats);
    }

    @Test
    public void testGetPlayerStatsName() throws InvalidNameException {
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Stats of a Player");
        System.out.print("\n---------------------------------------");

        final PlayerStatistic playerStatistic;
        playerStatistic = accessPlayerStats.getPlayerByName("Mark Scheifele");
        assertNotNull(playerStatistic);
        playerStatistic.viewPlayerStatObject();

    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
