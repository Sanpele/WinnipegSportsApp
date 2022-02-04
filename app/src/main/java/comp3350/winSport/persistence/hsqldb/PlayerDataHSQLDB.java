package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Player;
import comp3350.winSport.persistence.IPlayer;

public class PlayerDataHSQLDB implements IPlayer {

    private final String dbPath;

    public PlayerDataHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Player fromResultSet(final ResultSet rs) throws SQLException {

        final int playerID = rs.getInt("PlayerID");
        final String name = rs.getString("Player");
        final int number = rs.getInt("Number");
        final String position = rs.getString("Position");
        final String shot = rs.getString("Shot");
        final String teamName = rs.getString("teamName");

        return new Player(name,number,position,shot,teamName, R.drawable.headshot,playerID);
    }

    public List<Player> getPlayers(String teamName) {
        final List<Player> players = new ArrayList<>();

            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYERS WHERE teamName=?");
                st.setString(1, teamName);

                final ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    final Player player = fromResultSet(rs);
                    players.add(player);
                }

                rs.close();
                st.close();
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        return players;
    }

    public List<Player> getAllPlayers()  {

        final List<Player> players = new ArrayList<>();
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYERS");

                final ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    final Player player = fromResultSet(rs);
                    players.add(player);
                }
                rs.close();
                st.close();
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        return players;
    }
}
