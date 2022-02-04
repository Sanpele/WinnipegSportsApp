package comp3350.winSport.persistence;

import java.util.List;

import comp3350.winSport.objects.Comment;

public interface IComments {
    List<Comment> getComments(int postID);
    void insertComment(Comment comment);

}
