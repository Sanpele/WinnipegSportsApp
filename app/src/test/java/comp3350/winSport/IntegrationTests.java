package comp3350.winSport;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.winSport.business.AccessLocations;
import comp3350.winSport.business.AccessNewsFeed;
import comp3350.winSport.business.AccessPlayers;
import comp3350.winSport.business.AccessTeams;
import comp3350.winSport.tests.business.AccessCommentsIT;
import comp3350.winSport.tests.business.AccessGamesIT;
import comp3350.winSport.tests.business.AccessLocationsIT;
import comp3350.winSport.tests.business.AccessNewsFeedIT;
import comp3350.winSport.tests.business.AccessPlayerStatsIT;
import comp3350.winSport.tests.business.AccessPlayersIT;
import comp3350.winSport.tests.business.AccessStandingIT;
import comp3350.winSport.tests.business.AccessTeamsIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessGamesIT.class,
        AccessPlayersIT.class,
        AccessPlayerStatsIT.class,
        AccessTeamsIT.class,
        AccessCommentsIT.class,
        AccessLocationsIT.class,
        AccessStandingIT.class,
        AccessNewsFeedIT.class
})

public class IntegrationTests {
}
