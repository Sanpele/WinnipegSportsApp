package comp3350.winSport.objects;

public class Game {

    /*
        Game DSO specifically used for our currently playing and Schedule Features.
    */

    private int gameID;
    private String gameName;
    private String gameLeague;
    private String team1;
    private String team2;
    private String gameDate;
    private String gameLocation;
    private String gameScore;

    private int team1Pic;
    private int team2Pic;

    public Game(String team2 , String gameScore, int gamePicID) {
        this.team2 = team2;
        this.gameScore = gameScore;
        this.team1Pic = gamePicID;
    }

    public Game() {
        gameID = 0;
        gameName = "Unknown";
        gameLeague = "Unknown";
        team1 = "team1 Name";
        team2 = "team2 Name";
        gameDate = "Unknown";
        gameLocation = "Unknown";
        gameScore = "Unknown";
        team1Pic = 0;
        team2Pic = 0;
    }

    public Game(int gID, String gName, String gL, String t1, String t2, String gDate, String gLocation, String gScore) {
        gameID = gID;
        gameName = gName;
        gameLeague = gL;
        team1 = t1;
        team2 = t2;
        gameDate = gDate;
        gameLocation = gLocation;
        gameScore = gScore;
        team1Pic = 0;
        team2Pic = 0;
    }

    public Game(int gID, String gName, String gL, String t1, String t2, String gDate, String gLocation, String gScore, int lPic, int gPicID) {
        gameID = gID;
        gameName = gName;
        gameLeague = gL;
        team1 = t1;
        team2 = t2;
        gameDate = gDate;
        gameLocation = gLocation;
        gameScore = gScore;
        team1Pic = lPic;
        team2Pic = gPicID;
    }

    public void setTeam1Pic(int team1Pic) {
        this.team1Pic = team1Pic;
    }

    public void setTeam2Pic(int team2Pic) {
        this.team2Pic = team2Pic;
    }

    public int getTeam1Pic() {
        return team1Pic;
    }

    public int getTeam2Pic() {
        return team2Pic;
    }

    public int getGameID() {
        return gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameLeague() {
        return gameLeague;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getGameDate() {
        return gameDate;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public String getGameScore() {
        return gameScore;
    }

    public void setLeague(String name) {
        gameLeague = name;
    }

    //-------------------------------
    // viewGame()
    //
    // PURPOSE : For testing data. Command-line friendly version
    //           that prints out a single game information.
    //           Information printed is relevant to the user. A way to check if
    //           functions in AccessGames is actually outputting something meaningful.
    // PARAMETERS:
    //     None.
    //
    // Returns: None.
    //
    // ------------------------------
    public void viewGame(){
        System.out.print("\n\nGAME INFORMATION");
        System.out.print("\nGame ID: " + this.getGameID());
        System.out.print("\nGame Name: " + this.getGameName());
        System.out.print("\nLeague: "+ this.getGameLeague());
        System.out.print("\nGame Date: " + this.getGameDate());
        System.out.print("\nTeam 1: " + this.getTeam1());
        System.out.print("\nTeam 2: " + this.getTeam2());
        System.out.print("\nLocation: "+ this.getGameLocation());
        System.out.print("\nScore: " + this.getGameScore());
    }

    //-------------------------------
    // viewGame()
    //
    // PURPOSE : For testing data. Command-line friendly version
    //           that prints out the variables found in the constructor.
    // PARAMETERS:
    //     None.
    //
    // Returns: None.
    //
    // ------------------------------
    public void viewGameObject(){
        System.out.print("\n\nGAME OBJECT");
        System.out.print("\nGame ID: " + this.getGameID());
        System.out.print("\nGame Name: " + this.getGameName());
        System.out.print("\nLeague: "+ this.getGameLeague());
        System.out.print("\nGame Date: " + this.getGameDate());
        System.out.print("\nTeam 1: " + this.getTeam1());
        System.out.print("\nTeam 2: " + this.getTeam2());
        System.out.print("\nLocation: "+ this.getGameLocation());
        System.out.print("\nScore: " + this.getGameScore());
    }
}