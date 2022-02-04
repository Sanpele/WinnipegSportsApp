package comp3350.winSport.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.winSport.application.Services;
import comp3350.winSport.objects.Game;
import comp3350.winSport.persistence.IGame;
import comp3350.winSport.persistence.fakeDB.GameData;

public class AccessGames {

    /*
        Abstracts where the data is coming from using interfaces.
        What UI methods call to get data
    */

    private IGame gData;
    private List<Game> games;
    private Game game;
    private PictureChecker pc;

    public AccessGames() {
        gData = Services.getGamePersistance();
        games = null;
        game = null;
        pc = new PictureChecker();
    }

    public AccessGames(IGame accessingGames) {
        this();
        this.gData = accessingGames;
        pc = new PictureChecker();
    }

    public List<Game> getGames() {
        games = gData.getGamesSequential();

        games = initGamesPictures(games);

        return Collections.unmodifiableList(games);
    }

    public Game getSingleGame() {
        game = gData.getSingleGame();

        // Setting pictures for single game.
        if (game.getTeam1Pic() == 0 | game.getTeam2Pic() == 0) {
            game.setTeam1Pic(pc.getPic(game.getTeam1()));
            game.setTeam2Pic(pc.getPic(game.getTeam2()));
        }

        return game;
    }

    public List<Game> getGamesTeam(String teamName) {
        games = gData.getGamesSequential();
        List<Game> teamGames = new ArrayList<>();

        for (Game curr : games)
            if (curr.getTeam2().equals(teamName) || curr.getTeam1().equals(teamName))
                teamGames.add(curr);

        teamGames = initGamesPictures(teamGames);

        return teamGames;
    }

    public List<Game> initGamesPictures(List<Game> gs) {
        for (Game curr : gs) {
            if (curr.getTeam1Pic() == 0 | curr.getTeam2Pic() == 0) {
                curr.setTeam1Pic(pc.getPic(curr.getTeam1()));
                curr.setTeam2Pic(pc.getPic(curr.getTeam2()));
            }
        }
        return gs;
    }


}
