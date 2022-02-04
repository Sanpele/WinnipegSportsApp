package comp3350.winSport;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import comp3350.winSport.presentation.MainActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class NearestBarTest {
    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        mainRule.getActivity();
    }

    @Test
    public void viewNearestBars(){
        onView(withId(R.id.nearby_bars)).perform(click());
        onView(ViewMatchers.withId(R.id.venuesRV)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        //verify venues are displayed
        onView(allOf(withId(R.id.venuesRV))).check(matches(isDisplayed()));
    }

    @Test
    public void viewMultipleNearestBars(){
        onView(withId(R.id.nearby_bars)).perform(click());
        onView(ViewMatchers.withId(R.id.venuesRV)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        //verify venues are displayed
        onView(allOf(withId(R.id.venuesRV))).check(matches(isDisplayed()));
        pressBack();
        onView(ViewMatchers.withId(R.id.venuesRV)).perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        //verify venues are displayed
        onView(allOf(withId(R.id.venuesRV))).check(matches(isDisplayed()));
    }
}
