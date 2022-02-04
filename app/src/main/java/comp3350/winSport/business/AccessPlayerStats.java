package comp3350.winSport.business;

import comp3350.winSport.application.Services;
import comp3350.winSport.objects.PlayerStatistic;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayerStats;

public class AccessPlayerStats {

    /*
        Abstracts where the data is coming from using interfaces.
        What UI methods call to get data
    */

    private IPlayerStats playerStats;
    private PlayerStatistic oneStat;

    public AccessPlayerStats() {
        playerStats = Services.getPlayerStatsPersistance();
        oneStat = null;
    }

    public AccessPlayerStats(IPlayerStats ps) {
        this.playerStats = ps;
    }

    public PlayerStatistic getPlayerByName(String playerName) throws InvalidNameException {
        if (playerName.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$")) {
            oneStat = playerStats.getPlayerByName(playerName);
        }
        else {
            throw new InvalidNameException("please pass a team name with letters only");
        }
        return oneStat;
    }

}
