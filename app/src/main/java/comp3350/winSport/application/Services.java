package comp3350.winSport.application;

import comp3350.winSport.objects.Comment;
import comp3350.winSport.persistence.IComments;
import comp3350.winSport.persistence.IGame;
import comp3350.winSport.persistence.INewsFeed;
import comp3350.winSport.persistence.ILocation;
import comp3350.winSport.persistence.IPlayer;
import comp3350.winSport.persistence.IPlayerStats;
import comp3350.winSport.persistence.IStanding;
import comp3350.winSport.persistence.ITeam;
import comp3350.winSport.persistence.fakeDB.CommentsData;
import comp3350.winSport.persistence.fakeDB.GameData;
import comp3350.winSport.persistence.fakeDB.LocationData;
import comp3350.winSport.persistence.fakeDB.NewsFeedData;
import comp3350.winSport.persistence.fakeDB.PlayerData;
import comp3350.winSport.persistence.fakeDB.PlayerStatData;
import comp3350.winSport.persistence.fakeDB.StandingData;
import comp3350.winSport.persistence.fakeDB.TeamData;
import comp3350.winSport.persistence.hsqldb.CommentsHSQLDB;
import comp3350.winSport.persistence.hsqldb.GameDataHSQLDB;
import comp3350.winSport.persistence.hsqldb.LocationDataHSQLDB;
import comp3350.winSport.persistence.hsqldb.NewsFeedDataHSQLDB;
import comp3350.winSport.persistence.hsqldb.PlayerDataHSQLDB;
import comp3350.winSport.persistence.hsqldb.PlayerStatsHSQLDB;
import comp3350.winSport.persistence.hsqldb.StandingHSQLDB;
import comp3350.winSport.persistence.hsqldb.TeamDataHSQLDB;

public class    Services {

    // ONE LINE DB SWITCH BOOLEAN.
    // Set to false to use our Fake DB.
    private static final boolean useHSQLDB = true;

    private static ILocation locationPersistance = null;
    private static ITeam teamPersistance = null;
    private static IGame gamePersistance = null;
    private static IPlayer playerPersistance = null;
    private static IPlayerStats playerStatsPersistance = null;
    private static INewsFeed newsFeedPersistance=null;
    private static IStanding standingPersistance = null;
    private static IComments commentsPersistance=null;

    public static synchronized IStanding getStandingPersistance() {
        if (standingPersistance == null) {
            if (useHSQLDB)
                standingPersistance = new StandingHSQLDB(Main.getDBPathName());
            else
                standingPersistance = new StandingData();
        }
        return standingPersistance;
    }

    public static synchronized ILocation getLocationPersistance() {
        if (locationPersistance == null)
            if (useHSQLDB)
                locationPersistance = new LocationDataHSQLDB(Main.getDBPathName());
            else
                locationPersistance = new LocationData();
        return locationPersistance;
    }

    public static synchronized ITeam getTeamPersistance() {
        if (teamPersistance == null) {
            if (useHSQLDB)
                teamPersistance = new TeamDataHSQLDB(Main.getDBPathName());
            else
                teamPersistance = new TeamData();
        }
        return teamPersistance;
    }

    public static synchronized IGame getGamePersistance() {
        if (gamePersistance == null) {
            if (useHSQLDB)
                gamePersistance = new GameDataHSQLDB(Main.getDBPathName());
            else
                gamePersistance = new GameData();
        }
        return gamePersistance;
    }

    public static synchronized IPlayer getPlayerPersistance() {
        if(playerPersistance == null) {
            if (useHSQLDB)
                playerPersistance = new PlayerDataHSQLDB(Main.getDBPathName());
            else
                playerPersistance = new PlayerData();
        }
        return playerPersistance;
    }

    public static synchronized IPlayerStats getPlayerStatsPersistance() {
        if(playerStatsPersistance == null) {
            if (useHSQLDB)
                playerStatsPersistance = new PlayerStatsHSQLDB(Main.getDBPathName());
            else
                playerStatsPersistance = new PlayerStatData();
        }
        return playerStatsPersistance;
    }

    public static synchronized INewsFeed getNewsFeedPersistance()
    {
        if(newsFeedPersistance == null){
            if(useHSQLDB)
                newsFeedPersistance= new NewsFeedDataHSQLDB(Main.getDBPathName());
            else
                newsFeedPersistance=new NewsFeedData();
        }
        return newsFeedPersistance;
    }
    public  static  synchronized IComments getCommentsPersistance()
    {
        if(commentsPersistance==null)
        {
            if(useHSQLDB)
                commentsPersistance = new CommentsHSQLDB(Main.getDBPathName());
            else
                commentsPersistance=new CommentsData();
        }
        return commentsPersistance;
    }
}
