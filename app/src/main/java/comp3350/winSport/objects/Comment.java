package comp3350.winSport.objects;

public class Comment {
    private int postID;
    private String postTitle;
    private String comment;
    private String userNickName;

    public Comment()
    {
        //phineas and ferb reference
        this.userNickName="Cheeky Monkey";
        this.postID = 0;
        this.postTitle = "HACKA";
        this.comment = "blank comment";
    }
    public Comment(int postID,String postTitle,String comment)
    {
        userNickName="Cheeky Monkey";
        this.postID=postID;
        this.postTitle=postTitle;
        this.comment=comment;
    }

    public int getPostID() {
        return postID;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public String getComment() {
        return comment;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public void validateObject(){
        System.out.print("\nCOMMENT OBJECT");
        System.out.print("\nPost ID: " + getPostID());
        System.out.print("\nPost Title: " + getPostTitle());
        System.out.print("\nComment: " + getComment());
    }

}
