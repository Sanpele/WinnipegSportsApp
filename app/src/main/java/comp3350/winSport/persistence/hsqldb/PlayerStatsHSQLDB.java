package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.PlayerStatistic;
import comp3350.winSport.persistence.IPlayerStats;

public class PlayerStatsHSQLDB implements IPlayerStats {

    private final String dbPath;

    public PlayerStatsHSQLDB(final String dbPath)
    {
        this.dbPath=dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private PlayerStatistic fromResultSet(final ResultSet rs) throws SQLException {

        // opportunity for design patter? monster constructor not ideal design.

        final String psName = rs.getString("playerName");
        final int psGamesPlayed = rs.getInt("GamesPlayed");
        final String psTeam = rs.getString("Team");
        final String psLeague = rs.getString("League");
        final String psPosition = rs.getString("Position");
        final String psSeason = rs.getString("Season");
        final int psAge = rs.getInt("Age");
        final int psGoals = rs.getInt("Goals");
        final int psAssists = rs.getInt("Assists");
        final int psPoints = rs.getInt("Points");
        final double psGoalsPerGame = rs.getDouble("GoalsPerGame");
        final double psAssistsPerGame = rs.getDouble("AssistsPerGame");
        final double psShotsPerGame = rs.getDouble("ShotsPerGame");

        return new PlayerStatistic(psName,psGamesPlayed,psTeam,psLeague, psPosition,psSeason,psAge,psGoals,psAssists,psPoints,psGoalsPerGame,psAssistsPerGame,psShotsPerGame);

    }


    @Override
    public PlayerStatistic getPlayerByName(String name) {


        try (final Connection c = connection()) {

            // might need to either add error handling, or be Real sure that we pass a name that
            // exists.

            final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYER_STATS WHERE playerName=?");
            st.setString(1,name);

            final ResultSet rs = st.executeQuery();
            PlayerStatistic player = null;
            while (rs.next()) {
                player = fromResultSet(rs);
            }
            rs.close();
            st.close();

            return player;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

}
