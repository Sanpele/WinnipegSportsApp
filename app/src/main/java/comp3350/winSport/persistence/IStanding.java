package comp3350.winSport.persistence;

import java.util.List;

import comp3350.winSport.objects.Standing;

public interface IStanding {

    // SUUper simple interface, just getting for stanidng list in order.

    List<Standing> getStandingsInOrder();

}
