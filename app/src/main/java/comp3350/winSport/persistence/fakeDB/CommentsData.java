package comp3350.winSport.persistence.fakeDB;

import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.objects.Comment;
import comp3350.winSport.persistence.IComments;

public class CommentsData implements IComments {
    List<Comment> comments;
    public CommentsData()
    {
        comments=new ArrayList<>();
        initData();
    }

    public  void  initData(){
        comments.add(new Comment(1,"","Boo!!!"));
    }
    @Override
    public void insertComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments(int postID) {
        List<Comment> result;
        result=new ArrayList<>();
        for (int i = 0; i <comments.size(); i++) {
            if(comments.get(i).getPostID()==postID)
            {
                result.add(comments.get(i));
            }

        }
        return result;
    }
}
