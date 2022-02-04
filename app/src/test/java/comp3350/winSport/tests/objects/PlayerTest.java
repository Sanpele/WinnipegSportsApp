package comp3350.winSport.tests.objects;

import org.junit.Before;
import org.junit.Test;

import comp3350.winSport.objects.Player;

import static org.junit.Assert.assertNotNull;


public class PlayerTest {

    private Player player;

    @Before
    public void setUp(){
        player = new Player("Beatrix Kiddo",2,"center","Black Mamba",1);
        assertNotNull(player);
    }

    @Test
    public void validateObject(){
        System.out.print("\n------------------Player Test---------------------");
        System.out.print("\n---------------------------------------");
        System.out.print("\nTest 1: Validate Period Object");
        System.out.print("\n---------------------------------------");
        System.out.print("\nEnsures that created object instance contains the values passed when fetched.\n");
        player.viewPlayerObject();
    }

}
