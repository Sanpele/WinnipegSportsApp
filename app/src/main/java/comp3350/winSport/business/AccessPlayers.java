package comp3350.winSport.business;

import java.util.HashMap;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.application.Services;
import comp3350.winSport.objects.Player;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.IPlayer;

public class AccessPlayers {

    /*
        Abstracts player data access using interfaces.
        UI methods to get data
    */

    private IPlayer iplayer;
    private List<Player> players;
    private PictureChecker pc;

    public AccessPlayers() {
        iplayer = Services.getPlayerPersistance();
        players = null;
        pc = new PictureChecker();
    }

    public AccessPlayers(IPlayer playa) {
        this();
        iplayer = playa;
        this.pc = new PictureChecker();
    }

    public List<Player> getAllPlayers() {
        players = iplayer.getAllPlayers();
        setPics();
        return players;
    }

    public List<Player> getPlayersByTeam(String teamName) throws InvalidNameException {
        if(teamName.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") ) {
            players = iplayer.getPlayers(teamName);
            setPics();
        }
        else {
            throw new InvalidNameException("please pass a team name with letters only");
        }
        return players;
    }

    // loops through the list of players, using the PictureChecker class to assign
    // pictures to the players if they do not have a picture already.
    private void setPics() {
        for (Player curr: players)
            if (curr.getTeamPic() == 0)
                curr.setTeamPic(pc.getPic(curr.getTeam()));
    }

}
