package comp3350.winSport.objects;

import java.util.ArrayList;

import comp3350.winSport.exceptions.InvalidTimeException;

public class Period {

    /*
        Period DSO specifically Created for Track Live Game feature in upcomming iteration.
    */

    private int ID;
    private int score;
    private ArrayList<Player> playerGoals;
    private ArrayList<String> timeGoals;

    public Period() {
        ID = 0;
        score = 0;
        playerGoals = new ArrayList<>();
        timeGoals = new ArrayList<>();
    }

    public Period(int n, int sc) {
        ID = n;
        score = sc;
        playerGoals = new ArrayList<>();
        timeGoals = new ArrayList<>();
    }

    public void addGoal(Player p, String time) throws InvalidTimeException {
        if(time.matches("^\\d{2}:\\d{2}$")){
            playerGoals.add(p);
            timeGoals.add(time);
        }
        else{
            throw new InvalidTimeException("Please use time format in 00:00");
        }

    }

    public ArrayList<Player> getPlayerGoals() {
        return playerGoals;
    }

    public ArrayList<String> getTimeGoals() {
        return timeGoals;
    }

    public int getID() {
        return ID;
    }

    public int getScore() {
        return score;
    }

    public void setID(int n) {
        ID = n;
    }

    public void setScore(int s) {
        score = s;
    }

    public void setPlayerGoals(ArrayList<Player> pl) {
        playerGoals = pl;
    }

    public void setTimeGoals(ArrayList<String> st) {
        timeGoals = st;
    }

    public String toString() {
        String players = "";
        String period = "";
        if (ID == 1)
            period = "1ST";
        if(ID == 2)
            period = "2ND";
        if(ID == 3)
            period = "3RD";
        if(playerGoals.size() > 0) {
            for(int i = 0; i < playerGoals.size(); i++)
                players = players + "   " + playerGoals.get(i).getName() + " (" + timeGoals.get(i) + " " + period + ")\n";
            return "comp3350.winSport.objects.Period #" + ID + "\nGoals:\n" + players + "Score: " + score + "\n";
        }
        else
            return "comp3350.winSport.objects.Period #" + ID + "\n" + "Score: " + score + "\n";
    }

    public void viewPeriodObject(){
        System.out.print("\nPERIOD OBJECT");
        System.out.print("\nID: " + this.getID());
        System.out.print("\nScore: " + this.getScore() + "\n");
    }

}
