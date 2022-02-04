package comp3350.winSport.persistence;

import java.util.List;

import comp3350.winSport.objects.Game;

public interface IGame {
    List<Game> getGamesSequential();
    Game getSingleGame();
}
