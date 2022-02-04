package comp3350.winSport.persistence.fakeDB;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Game;
import comp3350.winSport.objects.Period;
import comp3350.winSport.objects.Player;
import comp3350.winSport.objects.Team;
import comp3350.winSport.persistence.IGame;

public class GameData implements IGame {

    List<Game> games;

    private Game g1;
    private Game g2;
    private Game g3;
    private Game g4;
    private Game g5;
    private Game g6;
    private Game g7;
    private Game g8;
    private Game g9;
    private Game g10;

    public GameData() {

        games  = new ArrayList<>();
        initData();

    }

    public void initData() {

        String league1 = "NHL";
        String league2 = "NHL";

        g1 = new Game(1, "Stanley Cup Playoffs", league1, "Winnipeg Jets", "Calgary Flames", "Mar 29, 2021", "Rogers Place", "5 - 1",R.drawable.jets, R.drawable.flames);
        g2 = new Game(2, "Stanley Cup Playoffs", league2, "Edmonton Oilers", "Montreal Canadiens", "Mar 30, 2021", "Scotiabank Arena", "0 - 4",R.drawable.oilers, R.drawable.montreal);
        g3 = new Game(3, "Stanley Cup Playoffs", league1, "Ottawa Senators", "Winnipeg Jets", "Apr 5, 2021", "Rogers Place", "3 - 4",R.drawable.ottawa, R.drawable.jets);
        g4 = new Game(4, "Stanley Cup Playoffs", league2, "Toronto Maple Leafs", "Calgary Flames", "Apr 6, 2021", "Scotiabank Arena", "TBP",R.drawable.leafs, R.drawable.flames);
        g5 = new Game(5, "Stanley Cup Playoffs", league1, "Winnipeg Jets", "Montreal Canadiens", "Apr 8, 2021", "Rogers Place", "TBP",R.drawable.jets, R.drawable.montreal);
        g6 = new Game(6, "Stanley Cup Playoffs", league2, "Vancouver Canucks", "Edmonton Oilers", "Apr 12, 2021", "Rogers Place", "TBP",R.drawable.vancouver, R.drawable.oilers);
        g7 = new Game(7, "Stanley Cup Playoffs", league1, "Winnipeg Jets", "Ottawa Senators", "Apr 12, 2021", "Rogers Place", "TBP",R.drawable.jets, R.drawable.ottawa);
        g8 = new Game(8, "Stanley Cup Playoffs", league2, "Calgary Flames", "Toronto Maple Leafs", "Apr 13, 2021", "Rogers Place", "TBP",R.drawable.flames, R.drawable.leafs);
        g9 = new Game(9, "Stanley Cup Playoffs", league1, "Ottawa Senators", "Montreal Canadiens", "Apr 17, 2021", "Rogers Place", "TBP",R.drawable.ottawa, R.drawable.montreal);
        g10 = new Game(10, "Stanley Cup Playoffs", league2, "Edmonton Oilers", "Winnipeg Jets", "Apr 17, 2021", "Rogers Place", "TBP",R.drawable.oilers, R.drawable.jets);

        games.add(g1);
        games.add(g2);
        games.add(g3);
        games.add(g4);
        games.add(g5);
        games.add(g6);
        games.add(g7);
        games.add(g8);
        games.add(g9);
        games.add(g10);

    }

    @Override
    public List<Game> getGamesSequential() {

        List<Game> games = new ArrayList<>();
        games.add(g1);
        games.add(g2);
        games.add(g3);
        games.add(g4);
        games.add(g5);
        games.add(g6);
        games.add(g7);
        games.add(g8);
        games.add(g9);
        games.add(g10);

        return games;
    }

    @Override
    public Game getSingleGame() {
        return this.g1;
    }

}
