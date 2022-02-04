package comp3350.winSport.persistence.fakeDB;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.objects.PlayerStatistic;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayerStats;

public class PlayerStatData implements IPlayerStats {

    List<PlayerStatistic> playerStats;

    public PlayerStatData() {
        playerStats = new ArrayList<>();
        initData();
    }

    void initData() {

        playerStats.add(new PlayerStatistic("Blake Wheeler",82,"WPG","NHL","C","2021-19",27,4,17,21,0.5,0.5,0.5));
        playerStats.add(new PlayerStatistic("Mark Scheifele",84,"WPG","NHL","LW","2021-19",27,6,17,21,0.1,0.1,0.1));
        playerStats.add(new PlayerStatistic("Mathieu Perreault",82,"WPG","NHL","D","2021-19",31,5,15,19,0.2,0.2,0.2));
        playerStats.add(new PlayerStatistic("Derek Forbort",82,"WPG","NHL","RW","2021-19",25,7,19,22,0.6,0.6,0.6));
        playerStats.add(new PlayerStatistic("Jansen Harkins",84,"WPG","NHL","C","2021-19",26,4,17,21,0.4,0.4,0.4));
        playerStats.add(new PlayerStatistic("Connor Hellebuyck",82,"WPG","NHL","G","2021-19",29,4,17,21,0.3,0.3,0.3));
        playerStats.add(new PlayerStatistic("Auston Matthews",82,"TML","NHL","C","2021-19",27,4,17,21,0.5,0.5,0.5));
        playerStats.add(new PlayerStatistic("Joe Thornton",84,"TML","NHL","LW","2021-19",27,6,17,21,0.1,0.1,0.1));
        playerStats.add(new PlayerStatistic("Travis Boyd",82,"TML","NHL","RW","2021-19",31,5,15,19,0.2,0.2,0.2));
        playerStats.add(new PlayerStatistic("T. J. Brodie",84,"TML","NHL","D","2021-19",25,7,19,22,0.6,0.6,0.6));
        playerStats.add(new PlayerStatistic("Pierre Engvall",82,"TML","NHL","RW","2021-19",26,4,17,21,0.4,0.4,0.4));
        playerStats.add(new PlayerStatistic("Alexander Kerfoot",84,"TML","NHL","C","2021-19",29,4,17,21,0.3,0.3,0.3));
        playerStats.add(new PlayerStatistic("Connor Brown",82,"OS","NHL","RW","2021-19",28,4,17,21,0.5,0.5,0.5));
        playerStats.add(new PlayerStatistic("Thomas Chabot",84,"OS","NHL","D","2021-19",27,4,17,21,0.2,0.2,0.2));
        playerStats.add(new PlayerStatistic("Evgenii Dadonov",82,"OS","NHL","RW","2021-19",26,4,17,21,0.3,0.3,0.3));
        playerStats.add(new PlayerStatistic("Nick Paul",84,"OS","NHL","LW","2021-19",24,4,17,21,0.6,0.6,0.6));
        playerStats.add(new PlayerStatistic("Drake Batherson",82,"OS","NHL","RW","2021-19",25,4,17,21,0.1,0.1,0.1));
        playerStats.add(new PlayerStatistic("Josh Norris",84,"OS","NHL","C","2021-19",30,4,17,21,0.9,0.9,0.9));
        playerStats.add(new PlayerStatistic("Tyson Barrie",82,"EO","NHL","D","2021-19",31,4,17,21,0.2,0.2,0.2));
        playerStats.add(new PlayerStatistic("Evan Bouchard",84,"EO","NHL","D","2021-19",29,4,17,21,0.6,0.6,0.6));
        playerStats.add(new PlayerStatistic("Alex Chiasson",82,"EO","NHL","RW","2021-19",22,4,17,21,0.7,0.7,0.7));
        playerStats.add(new PlayerStatistic("Connor McDavid",84,"EO","NHL","C","2021-19",26,4,17,21,0.3,0.3,0.3));
        playerStats.add(new PlayerStatistic("Ryan Nugent-Hopkins",82,"EO","NHL","LW","2021-19",24,4,17,21,0.4,0.4,0.4));
        playerStats.add(new PlayerStatistic("Tyler Ennis",84,"EO","NHL","LW","2021-19",27,4,17,25,0.8,0.8,0.8));
        playerStats.add(new PlayerStatistic("Rasmus Anderson",82,"CF","NHL","D","2021-19",27,4,17,21,0.5,0.5,0.5));
        playerStats.add(new PlayerStatistic("Elias Lindholm",84,"CF","NHL","C","2021-19",27,6,17,21,0.1,0.1,0.1));
        playerStats.add(new PlayerStatistic("Dillon Dube",82,"CF","NHL","C","2021-19",31,5,15,19,0.2,0.2,0.2));
        playerStats.add(new PlayerStatistic("Johnny Gaudreau",84,"CF","NHL","LW","2021-19",25,7,19,22,0.6,0.6,0.6));
        playerStats.add(new PlayerStatistic("Milan Lucic",82,"CF","NHL","LW","2021-19",26,4,17,21,0.4,0.4,0.4));
        playerStats.add(new PlayerStatistic("Connor Mackey",84,"CF","NHL","D","2021-19",29,4,17,21,0.3,0.3,0.3));
        playerStats.add(new PlayerStatistic("Brendan Gallagher",82,"MC","NHL","RW","2021-19",27,4,17,21,0.4,0.5,0.6));
        playerStats.add(new PlayerStatistic("Tyler Toffoli",84,"MC","NHL","LW","2021-19",27,4,17,21,0.3,0.2,0.1));
        playerStats.add(new PlayerStatistic("Phillip Danault",82,"MC","NHL","C","2021-19",27,4,17,21,0.4,0.3,0.5));
        playerStats.add(new PlayerStatistic("Jeff Petry",84,"MC","NHL","D","2021-19",27,4,17,21,0.55,0.75,0.65));
        playerStats.add(new PlayerStatistic("Josh Anderson",82,"MC","NHL","RW","2021-19",27,4,17,21,0.3,0.3,0.3));
        playerStats.add(new PlayerStatistic("Joel Armia",84,"MC","NHL","LW","2021-19",27,4,17,21,0.4,0.4,0.4));

    }

    @Override
    public PlayerStatistic getPlayerByName(String name)  {

        for (PlayerStatistic curr : playerStats) {
            if (curr.getName().equals(name))
                return curr;
        }

        return null;


    }

}
