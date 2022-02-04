package comp3350.winSport;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.winSport.presentation.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class BuyTicketsTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        mainRule.getActivity();
    }

    @Test
    public void viewBuyTickets(){
        onView(withId(R.id.buy_tickets_menu)).perform((click()));
        onView(withId(R.id.rv)).perform(swipeUp());
        //verify ticket links are displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
    }

}
