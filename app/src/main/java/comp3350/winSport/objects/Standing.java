package comp3350.winSport.objects;

public class Standing {

    /*
        Standing object contains a myriad of stats about a specific team.
        Initialized with either Fake DB or HSQLDB data.
     */

    // Unique identifier for standing object.
    private int teamID;

    private String teamName;
    private int wins;
    private int losses;
    private int ot_losses;
    private int pts;
    private String win_streak;
    private int teamPic;


    public Standing(int teamID, String teamName, int wins, int losses, int ot_losses, int pts, String win_streak) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
        this.ot_losses = ot_losses;
        this.pts = pts;
        this.win_streak = win_streak;
        this.teamPic = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getOt_losses() {
        return ot_losses;
    }

    public int getPts() {
        return pts;
    }

    public String getWin_streak() {
        return win_streak;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getTeamPic() {
        return teamPic;
    }

    public void setTeamPic(int pic) {this.teamPic = pic;}

    public void validateObject(){
        System.out.print("\nSTANDING OBJECT");
        System.out.print("\nTeam ID: " + getTeamID());
        System.out.print("\nTeam Name: " + getTeamName());
        System.out.print("\nWins: " + getWins());
        System.out.print("\nLosses: " + getLosses());
        System.out.print("\nOT Losses: " + getOt_losses());
        System.out.print("\nPoints: " + getPts());
        System.out.print("\nWin Streak: " + getWin_streak());
    }
}
