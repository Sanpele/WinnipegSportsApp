package comp3350.winSport.persistence.fakeDB;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.objects.Location;
import comp3350.winSport.persistence.ILocation;

public class LocationData implements ILocation {

    List<Location> locations;

    public LocationData()
    {
        locations=new ArrayList<>();
        initData();
    }

    void initData() {
        locations.add(new Location("MTS center","Bell MTS Place is an indoor arena in downtown Winnipeg, Manitoba. The arena is the home of the National Hockey Leagues Winnipeg Jets and their American Hockey League affiliate, the Manitoba Moose.","345 Portage Ave", 49.892493703214164, -97.14371951523503, false));
        locations.add(new Location("The Forks","Large riverside community hub with a variety of shopping, dining & recreational activities.","1 Forks Market Rd", 49.88722915942264, -97.13128231807245, false));
        locations.add(new Location("University Of Manitoba","The University of Manitoba is a non-denominational, public research university in the province of Manitoba","66 Chancellors Circle", 49.80746615969818, -97.13702286864483, false));
        locations.add(new Location("University Of Winnipeg","The University of Winnipeg is a public research university in Winnipeg, Manitoba, Canada","515 Portage Ave", 49.8912141750764, -97.15252761097221, false));
        locations.add(new Location("Kings Head Pub","Watering hole with a British & Indian menu, including a curry buffet, plus occasional live music.", "120 King St", 49.898813367428936, -97.14113546273671, true));
        locations.add(new Location("Classics Billiards Bar & Grill","Great food good music and wonderful staff and service", "1837 Portage Ave", 49.878908511451165, -97.2161272111264, true));
        locations.add(new Location("The Toad in the Hole","Great food good music and wonderful staff and service","155 Osborne St", 49.8772615259789, -97.1444813710595, true));
        locations.add(new Location("Bar Italia","A wide-ranging menu of global eats, from poutine to pasta, in a tavern setup with a sidewalk patio.", "737 Corydon Ave", 49.87121532013489, -97.15295639193933, true));
        locations.add(new Location("The Good Will Social Club","Community-minded watering hole, social club & coffeehouse offering pizza, beer & live music events." ,"625 Portage Ave", 49.88883623022975, -97.158161203587, true));
        locations.add(new Location("Shark Club Sports Bar & Grill","Nice place, dark, great for watching sports and for having pub style food.","233 Hargrave St", 49.89130261771731, -97.14327930961042, true));
        locations.add(new Location("The Roost on Corydon","Seasonal small plates & craft cocktails in a cosy, rustic-chic space with a rooftop terrace.","651 Corydon Ave", 49.872134694089844, -97.15010937844491, true));
        locations.add(new Location("Club 200","This small, gay bar with a disco ball features occasional go-go dancers & karaoke nights.","190 Garry St",49.890735251156016, -97.13924364683554, true));
        locations.add(new Location("The Canadian Brewhouse (Winnipeg)","Good atmosphere and service paired with average food and drinks and high prices.","1715 Kenaston Blvd", 49.820376758497325, -97.19747264591844, true));
        locations.add(new Location("Tavern United Polo Park","Pub fare, pints & cocktails in a comfortable sports-bar setting with pool tables & plenty of TVs.","1405 St Matthews Ave", 49.89116684788436, -97.19426527105911, true));
        locations.add(new Location("Shannons Irish Pub and Eatery","Busy Irish bar offering classic pub fare, live music, karaoke nights & a range of beers on tap.", "175 Carlton St",49.889479869760955, -97.14394365778507, true));
        locations.add(new Location("The Common","Great selection of beer and wine, friendly staff and a great atmosphere.", "1 Forks Market Rd", 49.88708126657703, -97.13120421543688, true));
        locations.add(new Location("The Cornerstone Bar & Restaurant","Relaxed joint offering comfort eats with a modern global twist, plus cocktails, wine & beer","93 Osborne St", 49.87897759918513, -97.1465033768485, true));
        locations.add(new Location("The Riverside: Tap & Table","Fun place, great crowd, great location, awesome atmosphere!","531 St Marys Rd", 49.86685656564652, -97.11045057501185, true));
        locations.add(new Location("Pony Corral Restaurant & Bar (Grant Park)","Ordered a meal which included salad.","400 Wilton St", 49.859362302537676, -97.16291115608303, true));
        locations.add(new Location("Garbonzos Sports Pub Polo Park","Nice place, awesome pizza, go after 9 on friday for discounts","1320 Ellice Ave", 49.89366513586186, -97.1943179253556, true));
        locations.add(new Location("Bleachers Sports Bar","Established watering hole featuring sports on TV, beer & pub grub like burgers & poutine.","308 Fort St", 49.894407294902294, -97.13971328616466, true));
        locations.add(new Location("Tavern United - Bell MTS Place","Pub fare, pints & cocktails in a comfortable sports-bar setting with pool tables & plenty of TVs.","345 Hargrave Street at, Graham Ave", 49.891897403178525, -97.14438570160327, true));
    }


    @Override
    public List<Location> getSportVenues() {

        List<Location> out = new ArrayList<>();

        for (Location curr : locations)
            if (!curr.isBar())
                out.add(curr);

        return out;
    }

    @Override
    public List<Location> getNearestBars() {
        List<Location> out = new ArrayList<>();

        for (Location curr : locations)
            if (curr.isBar())
                out.add(curr);

        return out;
    }

    @Override
    public Location getLocationByName(String name) {

        for (Location curr : locations)
            if (curr.getName().equals(name))
                return curr;

        return null;
    }
}
