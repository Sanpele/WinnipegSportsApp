package comp3350.winSport.business;

import java.util.Collections;
import java.util.List;

import comp3350.winSport.application.Services;
import comp3350.winSport.objects.Location;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.persistence.ILocation;

public class AccessLocations {

    public final static double AVERAGE_RADIUS_OF_EARTH_M = 6371000;

    private ILocation location;
    private List<Location> venues;
    private List<Location> bars;


    public AccessLocations() {
        // NEED TO ADD SERVICES CLASS.
        location = Services.getLocationPersistance();
        venues = null;
        bars = null;
    }

    public AccessLocations (ILocation iLocation){
        this.location = iLocation;
    }

    public List<Location> getVenues() {
        // no logic, can just return

        if (venues == null)
            venues = location.getSportVenues();

        return venues;
    }

    public Location getLocationByName(String name) {
        return location.getLocationByName(name);
    }

    public List<Location> getBars(String name) throws InvalidNameException {

        if(name.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") ) {
            // want to sort on calcuateDistance

            Location loc = this.getLocationByName(name);

            if (bars == null)
                bars = location.getNearestBars();

            for (Location curr : bars) {
                curr.setSortDist(calculateDistanceInmeter(loc.getLat(),loc.getLng(),curr.getLat(),curr.getLng()));
            }

            Collections.sort(bars,(Location::compareTo));

            return bars.subList(0,5);

        }
        else {
            throw new InvalidNameException("please pass a team name with letters only");
        }

    }

    private double calculateDistanceInmeter(Double userLat, Double userLng,
                                            Double venueLat, Double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (double) (Math.round(AVERAGE_RADIUS_OF_EARTH_M * c));
    }

}
