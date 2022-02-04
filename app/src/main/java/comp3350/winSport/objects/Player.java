package comp3350.winSport.objects;

import comp3350.winSport.R;

public class Player {

    /*
        Player DSO specifically used for our Roster and Player Stats features.
    */

    private String name;
    private int number;
    private String position;
    private String shot;

    public void setPlayerPic(int playerPic) {
        this.playerPic = playerPic;
    }

    private int playerPic;
    private String teamName;
    private int teamPic;
    private int playerID;

    public Player() {
        this.name = "Unknown";
        this.number = 0;
        this.position = "Unknown";
        this.shot = "L";
        this.playerPic = 0;
        this.teamName = "LFKAJDFLKJ";
        this.teamPic = 0;
        this.playerID = 0;
    }

    public Player(String name, int num, String pos, String teamName,int picID) {
        this.name = name;
        this.number = num;
        this.position = pos;
        this.shot = "l";
        this.playerPic = 0;
        this.teamName = teamName;
        this.teamPic = picID;
        this.playerID = 0;
    }

    public Player(String name, int num, String pos, String shot, String teamName, int picID, int playerID) {
        this.name = name;
        this.number = num;
        this.position = pos;
        this.shot = shot;
        this.playerPic = picID;
        this.teamName = teamName;
        this.teamPic = 0;
        this.playerID = playerID;

    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String nme) {
        name = nme;
    }

    public String getShot() {return this.shot;}

    public int getPic() {return this.playerPic;}

    public String getTeam() {return this.teamName;}

    public int getTeamPic() {return this.teamPic;}

    public void setNumber(int num) {
        number = num;
    }

    public void setPosition(String pos) {
        position = pos;
    }

    public void setTeamPic(int pic) {this.teamPic = pic;}

    public void viewPlayerObject(){
        System.out.print("\nPLAYER OBJECT");
        System.out.print("\nName: " + getName());
        System.out.print("\nNumber: " + getNumber());
        System.out.print("\nPosition: " + getPosition());
        System.out.print("\nTeam: " + getTeam());
        System.out.print("\nPic ID: " + getTeamPic());
    }
}