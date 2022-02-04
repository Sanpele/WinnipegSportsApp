package comp3350.winSport.persistence;

import java.util.List;

import comp3350.winSport.objects.Location;

public interface ILocation {

    List<Location> getSportVenues();
    List<Location> getNearestBars();
    Location getLocationByName(String name);
}
