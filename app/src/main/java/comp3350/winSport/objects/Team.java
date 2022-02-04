package comp3350.winSport.objects;

import java.util.List;

public class Team {

    /*
        Team DSO specifically used for our Roster and schedule features.
    */

    private String name;
    private int teamPic;
    private int teamID;

    public Team() {
        name = "Unknown";
        this.teamPic = 0;
        this.teamID = 0;
    }

    // constructor used when populating slower..
    public Team(String n, int teamPic, int teamID) {
        this.name = n;
        this.teamPic = teamPic;
        this.teamID = teamID;
    }

    public Team(String n, List<Player> pl, int teamPic,int teamID) {
        name = n;
        this.teamPic = teamPic;
        this.teamID = teamID;
    }

    public int getTeamPic() {
        return teamPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void setTeamPic(int pic) {this.teamPic = pic;}

    public String toString() {
        return this.name ;
    }

    public void viewTeamObject(){
        System.out.print("\nTEAM OBJECT");
        System.out.print("\nName: " + getName());
        System.out.print("\nTeam ID: " + getTeamPic());

    }

}
