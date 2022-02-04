package comp3350.winSport;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.winSport.presentation.MainActivity;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import androidx.test.espresso.contrib.RecyclerViewActions;

@RunWith(AndroidJUnit4.class)
public class PlayerStatisticsTest {
    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        mainRule.getActivity();
    }

    @Test
    public void viewPlayerStatistic(){
        onView(withId(R.id.player_stat_layout)).perform(click());
        onView(ViewMatchers.withId(R.id.player_rv_stats)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        //verify a player profile is displayed
        onView(allOf(withId(R.id.playerProfile))).check(matches(isDisplayed()));
    }

    @Test
    public void viewMultiplePlayerStatistic(){
        onView(withId(R.id.player_stat_layout)).perform(click());
        onView(ViewMatchers.withId(R.id.player_rv_stats)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        //verify a player profile is displayed
        onView(allOf(withId(R.id.playerProfile))).check(matches(isDisplayed()));
        pressBack();
        onView(ViewMatchers.withId(R.id.player_rv_stats)).perform(RecyclerViewActions.actionOnItemAtPosition(7,click()));
        //verify a player profile is displayed
        onView(allOf(withId(R.id.playerProfile))).check(matches(isDisplayed()));
    }

    @Test
    public void scrollPlayerList(){
        onView(withId(R.id.player_stat_layout)).perform(click());
        //verify players are displayed
        onView(allOf(withId(R.id.player_rv_stats))).check(matches(isDisplayed()));
        onView(withId(R.id.player_rv_stats)).perform(swipeUp());
    }

    @Test
    public void searchPlayerStatistic(){
        onView(withId(R.id.player_stat_layout)).perform(click());
        onView(withId(R.id.searchTxt)).perform(typeText("Dillon Dube"));
        closeSoftKeyboard();

        //verify Dillon Dube is displayed
        onView(allOf(withId(R.id.playerName), withText("Dillon Dube"))).check(matches(isDisplayed()));
    }

    @Test
    public void searchBadPlayerStatistic(){
        onView(withId(R.id.player_stat_layout)).perform(click());
        onView(withId(R.id.searchTxt)).perform(typeText("Player NotAPlayer"));
        closeSoftKeyboard();

        //verify Player NotAPlayer does not exist
        onView(allOf(withId(R.id.playerName), withText("Player NotAPlayer"))).check(doesNotExist());
    }
}
