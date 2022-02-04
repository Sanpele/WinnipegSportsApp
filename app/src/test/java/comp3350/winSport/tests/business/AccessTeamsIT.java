package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.winSport.business.AccessTeams;
import comp3350.winSport.objects.Team;
import comp3350.winSport.persistence.ITeam;
import comp3350.winSport.persistence.hsqldb.TeamDataHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessTeamsIT {

    private AccessTeams accessTeams;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final ITeam iTeam = new TeamDataHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        this.accessTeams = new AccessTeams(iTeam);
    }

    @Test
    public void testGetTeams(){
        System.out.print("\n------------------AccessTeams Integration Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Teams");
        System.out.print("\n---------------------------------------");
        final List<Team> teams = accessTeams.getTeams();
        assertEquals(6,teams.size());
    }

    @Test
    public void testGetSingleTeam(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Get Team Game");
        System.out.print("\n---------------------------------------");
        final Team team;
        team = accessTeams.getSingleTeam();
        assertNotNull(team);
    }

    @Test
    public void testGetTeamByName(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 3: Get Team By Name");
        System.out.print("\n---------------------------------------");

        final Team team;

        try{
            team = accessTeams.getTeamByName("Winnipeg Jets");
            assertNotNull(team);
            assertTrue("Winnipeg Jets".equals(team.getName()));
        }
        catch (Exception InvalidNameException){
            System.out.print("\nMethod threw an exception.\n");
        }

    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }

}
