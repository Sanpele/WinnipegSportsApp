package comp3350.winSport;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.winSport.application.Services;
import comp3350.winSport.persistence.IGame;
import comp3350.winSport.presentation.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class CurrentlyPlayingTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        mainRule.getActivity();
    }

    @Test
    public void viewCurrentGames(){
        onView(withId(R.id.currentlyPlayingMenu)).perform(click());
        //verify that games are displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        onView(withId(R.id.rv)).perform(swipeUp());
    }
}
