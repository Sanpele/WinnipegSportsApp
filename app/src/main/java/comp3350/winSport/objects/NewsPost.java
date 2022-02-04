package comp3350.winSport.objects;

public class NewsPost {

    private static int postCount=0;

    private int postID;
    private String title;
    private String datePosted;
    private String caption;
    private int numLikes;
    private int image;
    private int likes;
    private int dislikes;
    private boolean isLiked;
    private boolean isDisliked;

    // Null constructor.
    public NewsPost()
    {
        title="The Title";
        datePosted="12/03/19";
        caption="Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
        numLikes=0;
        image = 0;
        postID = postCount;
        postCount++;
        likes=0;
        dislikes=0;
        isLiked=false;
        isDisliked=false;
    }

    public NewsPost(int postID,String title,String datePosted ,String caption, int likes,int dislikes,int image)
    {
        this.postID = postID;
        this.title=title;
        this.datePosted=datePosted;
        this.caption=caption;
        this.likes=likes;
        this.dislikes=dislikes;
        this.image=image;
        postCount++;
    }
    public boolean isLiked()
    {
        return isLiked;
    }


    // COLIN : I think we need a messy method like to to handle the logic, Its good its here and not
    // in the presentation layer. I tried to Comment each if/else block to make things a bit more readable
    // and i also changed how you increment/deincrement because i don't think we have to use getters/setters
    // inside the object, and i think it looks cleaner without them.
    public void likePost(boolean likeButtonPressed)
    {
        // Nothing liked yet
        if(!isLiked && !isDisliked && likeButtonPressed )
        {
            isLiked=true;
            likes+=1;
        }
        // already liked and liked pressed again.
        else if(isLiked && !isDisliked && likeButtonPressed){
            isLiked=false;
            likes-=1;
        }
        // Disliked already selected, and liked pressed.
        // Cancels out disliked and increments liked.
        else if(!isLiked && isDisliked && likeButtonPressed)
        {
            isDisliked=false;
            isLiked=true;
            likes+=1;
            dislikes-=1;
        }
        // already disliked and disliked pressed again
        else if(!isLiked && isDisliked && !likeButtonPressed){
            isDisliked=false;
            dislikes-=1;
        }
        // nothing selected and disliked clicked.
        else if(!isLiked && !isDisliked && !likeButtonPressed)
        {
            isDisliked=true;
            dislikes+=1;
        }
        // liked already selected and disliked now selected
        else if(isLiked && !isDisliked && !likeButtonPressed){
            isDisliked=true;
            isLiked=false;
            likes-=1;
            dislikes+=1;
        }
    }



    public static int getPostCount() {
        return postCount;
    }
    public void setDislikes(int dislikes)
    {
        this.dislikes=dislikes;
    }

    public int getImage()
    {
        return image;
    }

    public int getPostID() {
        return postID;
    }

    public String getTitle() {
        return title;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public String getCaption() {
        return caption;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isDisliked()
    {
        return isDisliked;
    }

    public void validateObject(){
        System.out.print("\nNEWSPOST OBJECT");
        System.out.print("\nPost ID: " + getPostID());
        System.out.print("\nTitle: " + getTitle());
        System.out.print("\nDate Posted: " + getDatePosted());
        System.out.print("\nCaption: " + getCaption());
        System.out.print("\nLikes: " + getLikes());
        System.out.print("\nDislikes: " + getDislikes());
        System.out.print("\nImage: " + getImage());
    }
}
