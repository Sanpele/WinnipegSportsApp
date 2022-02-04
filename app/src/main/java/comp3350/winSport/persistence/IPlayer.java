package comp3350.winSport.persistence;

import java.util.List;

import comp3350.winSport.objects.Player;
import comp3350.winSport.exceptions.InvalidNameException;

public interface IPlayer {
    List<Player> getPlayers(String teamName) ;
    List<Player> getAllPlayers();
}
