package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.Comment;
import comp3350.winSport.persistence.IComments;

public class CommentsHSQLDB implements IComments {

    private final String dbPath;

    public CommentsHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Comment fromResultSet(final ResultSet rs) throws SQLException {

        final int postID = rs.getInt("postID");
        final String postTitle = rs.getString("postTitle");
        final String comment = rs.getString("comment");

        return new Comment(postID,postTitle,comment);
    }

    @Override
    public List<Comment> getComments(int postID) {
        // will return a null list if no posts found.
        final List<Comment> comments = new ArrayList<>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM comments where postID = ?");
            st.setInt(1, postID);

            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final Comment comment = fromResultSet(rs);
                comments.add(comment);
            }

            rs.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return comments;
    }

    @Override
    public void insertComment (Comment comment) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO COMMENTS VALUES(?,?,?)");
            st.setInt(1,comment.getPostID());
            st.setString(2,comment.getPostTitle());
            st.setString(3,comment.getComment());
            st.executeUpdate();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
