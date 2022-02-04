package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Game;

import comp3350.winSport.persistence.IGame;

public class GameDataHSQLDB implements IGame {

    private final String dbPath;

    public GameDataHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws  SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Game fromResultSet(final ResultSet rs) throws SQLException {
        final int gameID = rs.getInt("GAMEID");
        final String gameName = rs.getString("GAMENAME");
        final String gameLeague = rs.getString("LEAGUENAME");
        final String t1Name = rs.getString("TEAM1ID");
        final String t2Name = rs.getString("TEAM2ID");
        final String gameDate = rs.getString("DATE");
        final String gameLocation = rs.getString("LOCATION");
        final String gameScore = rs.getString("SCORE");

        return new Game(gameID,gameName,gameLeague,t1Name,t2Name,gameDate,gameLocation,gameScore);
    }
    
    @Override
    public List<Game> getGamesSequential() {

        final List<Game> games = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM GAMES");

            while (rs.next()) {
                final Game game = fromResultSet(rs);
                games.add(game);
            }

            rs.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return games;

    }

    @Override
    public Game getSingleGame() {

        try (final Connection c = connection()) {

            final PreparedStatement st = c.prepareStatement("SELECT TOP 1 * FROM GAMES");
            final ResultSet rs = st.executeQuery();
            final Game game;

            if (rs.next())
                game = fromResultSet(rs);
            else
                game = new Game();
            rs.close();
            st.close();

            return game;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }

    }

}
