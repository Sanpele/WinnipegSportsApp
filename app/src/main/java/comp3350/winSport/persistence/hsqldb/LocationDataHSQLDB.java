package comp3350.winSport.persistence.hsqldb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Location;
import comp3350.winSport.persistence.ILocation;

public class LocationDataHSQLDB implements ILocation {

    private final String dbPath;

    public LocationDataHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Location fromResultSet(final ResultSet rs) throws SQLException {

        final String name = rs.getString("locationName");
        final String description = rs.getString("locationDescription");
        final String address = rs.getString("locationAddress");
        final BigDecimal lat = rs.getBigDecimal("locationLat");
        final BigDecimal lng = rs.getBigDecimal("locationLong");
        final boolean bit = rs.getBoolean("locationBar");
        return new Location(name,description,address,lat.doubleValue(),lng.doubleValue(),bit);
    }

    @Override
    public List<Location> getSportVenues() {

        final List<Location> locations = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM LOCATIONS WHERE locationBar = FALSE");

            while (rs.next()) {
                final Location location = fromResultSet(rs);
                locations.add(location);
            }

            rs.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return locations;
    }

    @Override
    public List<Location> getNearestBars() {

        final List<Location> locations = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM LOCATIONS WHERE locationBar = TRUE");

            while (rs.next()) {
                final Location location = fromResultSet(rs);
                locations.add(location);
            }

            rs.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return locations;
    }

    @Override
    public Location getLocationByName(String name) {
        Location location = null;

        try (final Connection c = connection()) {

            final PreparedStatement st = c.prepareStatement("SELECT * FROM LOCATIONS WHERE locationName=?");
            st.setString(1,name);

            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                location = fromResultSet(rs);
            }
            rs.close();
            st.close();

        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return location;
    }
}
