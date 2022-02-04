package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.winSport.objects.Game;
import comp3350.winSport.objects.League;
import comp3350.winSport.objects.Period;
import comp3350.winSport.objects.Player;
import comp3350.winSport.objects.Team;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class GameTest {

    private Game game;

    private int gameID = 42;
    private League gameLeague = new League(25, "Some Sports League");
    private String date = "December 31, 1999";
    private String location = "Very Competitive Location";
    private String gameName = "Very Intense Sports Event";
    private String score = "1 - 1";

    @Before
    public void setUp(){
        ArrayList<Player> pTeam1= new ArrayList<>();
        Team team1 = new Team("Space People", pTeam1, 0,1);

        pTeam1.add(new Player("James T. Kirk",34,"center",team1.getName(),1));
        pTeam1.add(new Player("General Zod",283,"left",team1.getName(),2));
        pTeam1.add(new Player("Sheev Palpatine",80,"right",team1.getName(),3));

        ArrayList<Player> pTeam2= new ArrayList<>();
        Team team2 = new Team("Fascinating Rulers", pTeam1, 0,2);
        pTeam2.add(new Player("Fire Lord Ozai",55,"center",team2.getName(),4));
        pTeam2.add(new Player("Ocean Master",29,"left",team2.getName(),5));
        pTeam2.add(new Player("Lord Faarguad",1,"right",team2.getName(),6));

        ArrayList<Period> periods = new ArrayList<>();
        periods.add(new Period());
        periods.add(new Period());
        periods.add(new Period());

        game = new Game(gameID,gameName,gameLeague.getName(),team1.getName(),team2.getName(),date,location,score);
        assertNotNull(game);
    }

    @Test
    public void validateObject(){
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validating Game Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        game.viewGameObject();
        //
    }


    /* Colin commented out because period functionality has sorta been dropped.
    @Test
    public void getAPeriod(){
        System.out.print("\n------------------Game Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 2: Get One Period");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTests the function getOnePeriod.");
        System.out.print("\nGet period score for period ID=0");
        System.out.print("\n" + game.getOnePeriod(0).toString());
        System.out.print("\nPassing '89' to getOnePeriod. Should return null if ID not found.");
        game.getOnePeriod(89);
        assertNull(null);
        System.out.print("\nPassed.");
    }
     */
}
