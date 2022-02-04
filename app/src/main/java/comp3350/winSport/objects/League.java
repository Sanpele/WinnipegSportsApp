package comp3350.winSport.objects;

public class League {

    /*
        league DSO specifically used for our currently playing Feature.
    */

    private int ID;
    private String name;

    public League() {
        ID = 0;
        name = "Unknown";
    }

    public League(int n, String m) {
        ID = n;
        name = m;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int n) {
        ID = n;
    }

    public void setName(String s) {
        name = s;
    }

    public String toString() {
        return "comp3350.winSport.objects.League: [" + ID + "] " + name;
    }

    public void viewLeagueObject(){
        System.out.print("\nLEAGUE OBJECT");
        System.out.print("\nGame ID: " + getID());
        System.out.print("\nLeague Name: " + getName());
    }

}
