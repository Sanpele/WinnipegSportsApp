package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Team;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.ITeam;

public class TeamDataHSQLDB implements ITeam {

    /*
        Simple HSQLDB class, only has getter methods.
     */

    private final String dbPath;

    public TeamDataHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Team fromResultSet(final ResultSet rs) throws SQLException {
        final String teamName = rs.getString("NAME");
        final int teamID;

        teamID = rs.getInt("teamID");
        int pic = 0;
        return new Team(teamName, pic, teamID);
    }

    @Override
    public List<Team> getTeams() { // RETURNS ALL TEAMS EVER

        final List<Team> teams = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT DISTINCT * FROM TEAMS");

            while (rs.next()) {
                final Team team = fromResultSet(rs);
                teams.add(team);
            }

            rs.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return teams;
    }

    @Override
    public Team getSingleTeam() { // RETURNS FIRST TEAM
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT TOP 1 * FROM PUBLIC.TEAMS");
            final ResultSet rs = st.executeQuery();
            final Team team;
            if (rs.next())
                team = fromResultSet(rs);
            else
                team = new Team();

            rs.close();
            st.close();

            return team;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Team getTeamByName(String name)  { // RETURNS TEAM, GETS SPECIFIC NAME

        final List<Team> teams = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM TEAMS WHERE NAME='" + name + "'");

            while (rs.next()) {
                final Team team = fromResultSet(rs);
                teams.add(team);
            }
            rs.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        for (Team curr : teams) {
            if (curr.getName().equals(name))
                return curr;
        }

        return null;
    }

}
