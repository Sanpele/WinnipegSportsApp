package comp3350.winSport.objects;

public class Channel {

    private int name;
    private int pic;

    public Channel(int name, int pic) {
        this.name = name;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void validateObject(){
        System.out.print("\nCHANNEL OBJECT");
        System.out.print("\nChannel Name: " + getName());
        System.out.print("\nChannel Pic: " + getPic());
    }

}
