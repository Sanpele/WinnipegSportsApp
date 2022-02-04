package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import comp3350.winSport.business.AccessStanding;
import comp3350.winSport.objects.Standing;
import comp3350.winSport.persistence.IStanding;
import comp3350.winSport.persistence.hsqldb.StandingHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessStandingIT {
    private AccessStanding accessStanding;
    private File tempDB;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final IStanding iStanding = new StandingHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        this.accessStanding = new AccessStanding(iStanding);
    }

    @Test
    public void testGetStandingsInOrder(){
        System.out.print("\n------------------AccessStandings Integration Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Standings in Order");
        System.out.print("\n---------------------------------------");
        final List<Standing> standings = accessStanding.getStandingInOrder();
        assertNotNull(standings);
        assertEquals(6,standings.size());
        System.out.print("\nFinished test.");
    }

    @Test
    public void testGetStandingsInOrderData(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Test Get Standings in Order Data ");
        System.out.print("\n---------------------------------------");
        final List<Standing> standings = accessStanding.getStandingInOrder();
        ListIterator<Standing> iterator = standings.listIterator();
        System.out.print("\nIterating through list...");

        while(iterator.hasNext()){
            Standing standing = iterator.next();
            standing.validateObject();
            System.out.print("\n");
        }

        System.out.print("\nFinished test.");
    }


    @After
    public void tearDown(){
        this.tempDB.delete();
    }
}
