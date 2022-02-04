package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;



import comp3350.winSport.objects.Player;
import comp3350.winSport.objects.Team;


public class TeamTest {

    private Team team;
    private String teamName = "Tune Squad";

    @Before
    public void setUp(){
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Michael Jordan", 23,"left",teamName,1));
        playerList.add(new Player("Bugs Bunny", 0,"right",teamName,2));
        playerList.add(new Player("Porky Pig", 1,"center",teamName,3));
        team = new Team(teamName,playerList, 1,3);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Team Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validate Period Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        team.viewTeamObject();
    }


}
