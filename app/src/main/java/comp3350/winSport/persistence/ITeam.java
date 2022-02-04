package comp3350.winSport.persistence;

import java.util.List;

import comp3350.winSport.exceptions.InvalidNameException;
import comp3350.winSport.objects.Team;

public interface ITeam {

    /*
        Used by ScheduleActivity and TeamsActivity.

        ScheduleActivity feeds into -> TeamScheduleActivity.
        while
        TeamsActivity feeds into -> RosterActivity.

     */

    List<Team> getTeams();
    Team getSingleTeam();
    Team getTeamByName(String name) ;
}
