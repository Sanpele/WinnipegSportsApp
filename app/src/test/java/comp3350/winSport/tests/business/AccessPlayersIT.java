package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import comp3350.winSport.business.AccessPlayers;

import comp3350.winSport.objects.Player;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayer;
import comp3350.winSport.persistence.hsqldb.PlayerDataHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;

public class AccessPlayersIT {

    private AccessPlayers accessPlayers;
    private File tempDB;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final IPlayer iPlayer= new PlayerDataHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessPlayers = new AccessPlayers(iPlayer);
    }

    @Test
    public void testGetPlayersByTeam() throws InvalidNameException {
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Players of a Team");
        System.out.print("\n---------------------------------------");
        List<Player> players = accessPlayers.getPlayersByTeam("Winnipeg Jets");
        assertNotNull(players);
        ListIterator<Player> iterator = players.listIterator();

        System.out.print("\nIterating through list...");
        while (iterator.hasNext()){
            Player player = iterator.next();
            assertNotNull(player);
            player.viewPlayerObject();
            System.out.print("\n-----------");
        }
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }

}
