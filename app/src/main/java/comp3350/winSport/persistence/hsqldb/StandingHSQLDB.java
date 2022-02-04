package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Standing;
import comp3350.winSport.persistence.IStanding;

public class StandingHSQLDB implements IStanding {

    /*
        As basic as it gets HSQLDB class, only thing of note is specific SQL query to
        return table in order.
    */

    private final String dbPath;

    public StandingHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Standing fromResultSet(final ResultSet rs) throws SQLException {

        final int teamID = rs.getInt("TEAMID");
        final String teamName = rs.getString("teamName");
        final int wins = rs.getInt("wins");
        final int losses = rs.getInt("losses");
        final int ot_losses = rs.getInt("ot_losses");
        final int points = rs.getInt("points");
        final String winStreak = rs.getString("win_streak");

        return new Standing(teamID,teamName,wins,losses,ot_losses,points,winStreak);

    }

    @Override
    public List<Standing> getStandingsInOrder() {

        final List<Standing> standings = new ArrayList<>();
        try(final Connection c = connection()) {

            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("select * from STANDINGS order by points desc");

            while(rs.next()) {
                final Standing standing = fromResultSet(rs);
                standings.add(standing);
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return standings;
    }
}
