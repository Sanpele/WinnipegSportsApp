package comp3350.winSport.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.winSport.R;
import comp3350.winSport.exceptions.PersistenceException;
import comp3350.winSport.objects.NewsPost;

import comp3350.winSport.persistence.INewsFeed;

public class NewsFeedDataHSQLDB implements INewsFeed {
    private final String dbPath;

    public NewsFeedDataHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private NewsPost fromResultSet(final ResultSet rs) throws SQLException
    {
        final int postID = rs.getInt("POSTID");
        final String title = rs.getString("TITLE");
       // final int psGamesPlayed = rs.getInt("GamesPlayed");
        final String datePosted= rs.getString("DATEPOSTED");
        final String caption = rs.getString("CAPTION");

        final int numLikes = rs.getInt("LIKES");
        final int numDisLikes=rs.getInt("DISLIKES");
        int image;

        if (postID % 3 == 0)
            image = R.drawable.trade_deadline;
        else if (postID % 3 == 1)
            image = R.drawable.oilers_jets;
        else
            image = R.drawable.cole;

        return new NewsPost(postID,title,datePosted,caption,numLikes,numDisLikes,image);


    }

    @Override
    public List<NewsPost> getNewsPosts()   {
        List<NewsPost> newsPosts;
        newsPosts=new ArrayList<>();
        try(final Connection c=connection())
        {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM NEWS_FEED");

            while (rs.next()) {
                final NewsPost newsPost = fromResultSet(rs);
                newsPosts.add(newsPost);
            }

            rs.close();
            st.close();

        }catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return newsPosts;
   //  return null;
    }

    @Override
    public void updateLike(int id,int val) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE NEWS_FEED SET LIKES = ? WHERE POSTID = ?");
            st.setInt(1, val);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void updateDislike(int id,int val) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE NEWS_FEED SET DISLIKES = ? WHERE POSTID = ?");
            st.setInt(1, val);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
