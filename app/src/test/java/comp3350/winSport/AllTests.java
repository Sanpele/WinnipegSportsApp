package comp3350.winSport;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.winSport.tests.business.AccessCommentsTest;
import comp3350.winSport.tests.business.AccessGamesTest;
import comp3350.winSport.tests.business.AccessLocationsTest;
import comp3350.winSport.tests.business.AccessNewsFeedTest;
import comp3350.winSport.tests.business.AccessPlayerStatsTest;
import comp3350.winSport.tests.business.AccessPlayersTest;
import comp3350.winSport.tests.business.AccessStandingTest;
import comp3350.winSport.tests.business.AccessTeamsTest;
import comp3350.winSport.tests.business.PictureCheckerTest;
import comp3350.winSport.tests.objects.ChannelTest;
import comp3350.winSport.tests.objects.CommentTest;
import comp3350.winSport.tests.objects.GameTest;
import comp3350.winSport.tests.objects.LeagueTest;
import comp3350.winSport.tests.objects.LocationTest;
import comp3350.winSport.tests.objects.NewsPostTest;
import comp3350.winSport.tests.objects.PeriodTest;
import comp3350.winSport.tests.objects.PlayerStatisticTest;
import comp3350.winSport.tests.objects.PlayerTest;
import comp3350.winSport.tests.objects.StandingTest;
import comp3350.winSport.tests.objects.TeamTest;
import comp3350.winSport.tests.objects.TicketTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessTeamsTest.class,
        AccessGamesTest.class,
        GameTest.class,
        LeagueTest.class,
        PeriodTest.class,
        PlayerTest.class,
        TeamTest.class,
        AccessPlayerStatsTest.class,
        AccessPlayersTest.class,
        AccessCommentsTest.class,
        AccessLocationsTest.class,
        AccessNewsFeedTest.class,
        AccessStandingTest.class,
        PictureCheckerTest.class,
        ChannelTest.class,
        CommentTest.class,
        LocationTest.class,
        NewsPostTest.class,
        PlayerStatisticTest.class,
        StandingTest.class,
        TicketTest.class
})

public class AllTests {
}
