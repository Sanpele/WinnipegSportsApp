package comp3350.winSport.objects;

public class Ticket {
    private String name;
    private int link;
    private int pic;

    public Ticket(String name, int link, int pic) {
        this.name = name;
        this.link = link;
        this.pic = pic;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void viewTicketObject(){
        System.out.print("\nTICKET OBJECT");
        System.out.print("\nName: " + getName());
        System.out.print("\nLink: " + getLink());
        System.out.print("\nPic: " + getPic());
    }
}
