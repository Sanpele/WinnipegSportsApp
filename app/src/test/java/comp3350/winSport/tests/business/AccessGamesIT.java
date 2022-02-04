package comp3350.winSport.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import comp3350.winSport.business.AccessGames;
import comp3350.winSport.objects.Game;
import comp3350.winSport.persistence.IGame;
import comp3350.winSport.persistence.hsqldb.GameDataHSQLDB;
import comp3350.winSport.tests.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessGamesIT {

    private AccessGames accessGames;
    private File tempDB;

    @Before
    public void setup() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final IGame iGame = new GameDataHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessGames = new AccessGames(iGame);
    }

    @Test
    public void testGetGames(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Get Games");
        System.out.print("\n---------------------------------------");
        final List<Game> games = accessGames.getGames();
        assertEquals(27,games.size());
    }

    @Test
    public void testGetSingleGame(){
        System.out.print("\n------------------AccessGames Integration Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Get Single Game");
        System.out.print("\n---------------------------------------");
        final Game game;
        game = accessGames.getSingleGame();
        assertNotNull(game);
    }

    @Test
    public void testGetGamesTeam(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 3: Get Games of a Team");
        System.out.print("\n---------------------------------------");
        List<Game> gameList = accessGames.getGamesTeam("Winnipeg Jets");
        assertNotNull(gameList);
        ListIterator<Game> iterator = gameList.listIterator();

        System.out.print("\nIterating through list...");
        while (iterator.hasNext()){
            Game game = iterator.next();
            assertNotNull(game);
            game.viewGameObject();
        }

        System.out.print("\nFinished test.");

    }


    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }

}
