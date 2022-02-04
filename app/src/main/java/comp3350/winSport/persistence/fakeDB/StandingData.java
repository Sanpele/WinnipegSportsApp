package comp3350.winSport.persistence.fakeDB;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.objects.Standing;
import comp3350.winSport.persistence.IStanding;

public class StandingData implements IStanding {

    /*
        Simple fake method, returns sorted standings array sorted by points.
     */

    private List<Standing> standings;

    private Standing s1;
    private Standing s2;
    private Standing s3;
    private Standing s4;
    private Standing s5;
    private Standing s6;

    public StandingData() {
        standings = new ArrayList<>();
        initData();
    }

    private void initData() {

        s1 = new Standing(1,"Winnipeg Jets",19,11,2,40,"W1");
        s2 = new Standing(2,"Toronto Maple Leafs",20,10,2,42,"W1");
        s3 = new Standing(3,"Ottawa Senators",12,20,3,27,"W2");
        s4 = new Standing(4,"Edmonton Oilers",21,13,0,42,"W3");
        s5 = new Standing(5,"Calgary Flames",15,16,3,33,"L3");
        s6 = new Standing(6,"Montreal Canadiens",14,8,9,37,"W1");

        standings.add(s1);
        standings.add(s2);
        standings.add(s3);
        standings.add(s4);
        standings.add(s5);
        standings.add(s6);
    }

    @Override
    public List<Standing> getStandingsInOrder() {

        Collections.sort(standings, (o1, o2) -> (o2.getPts() - o1.getPts()));

        return standings;
    }

}
