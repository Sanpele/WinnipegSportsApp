package comp3350.winSport.persistence;


import comp3350.winSport.objects.PlayerStatistic;
import comp3350.winSport.exceptions.InvalidNameException;

public interface IPlayerStats {
    PlayerStatistic getPlayerByName(String name) ;
}