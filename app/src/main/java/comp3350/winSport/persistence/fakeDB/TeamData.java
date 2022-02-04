package comp3350.winSport.persistence.fakeDB;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.objects.Team;
import comp3350.winSport.persistence.ITeam;

public class TeamData implements ITeam {

    /*
        Simple Fake DB with hardcoded team data.
     */

    List<Team> teams;

    Team t1;
    Team t2;
    Team t3;
    Team t4;
    Team t5;
    Team t6;


    public TeamData() {
        teams = new ArrayList<>();
        initData();
    }

    void initData() {

        t1 = new Team("Winnipeg Jets", R.drawable.jets,0);
        t2 = new Team("Toronto Maple Leafs",R.drawable.leafs,1);
        t3 = new Team("Ottawa Senators", R.drawable.ottawa,2);
        t4 = new Team("Edmonton Oilers", R.drawable.oilers,3);
        t5 = new Team("Calgary Flames", R.drawable.flames,4);
        t6 = new Team("Montreal Canadiens",R.drawable.montreal,5);

        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t4);
        teams.add(t5);
        teams.add(t6);

    }


    // Return all teams
    @Override
    public List<Team> getTeams() {
        return teams;
    }

    // just returns winnipeg jets if only 1 team is required.
    @Override
    public Team getSingleTeam() {
        return t1;
    }

    // Return team by name
    @Override
    public Team getTeamByName(String name)  {

        for (Team curr : teams) {
            if (curr.getName().equals(name))
                return curr;
        }

        //If team is not in the list.
        return null;
    }
}
