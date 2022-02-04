package comp3350.winSport;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import comp3350.winSport.presentation.MainActivity;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class NewsFeedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        mainRule.getActivity();
    }

    @Test
    public void viewNewsFeed(){
        onView(withId(R.id.newsFeedMenu)).perform(click());
        //verify newsfeed is displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
    }

    @Test
    public void scrollNewsFeed(){
        onView(withId(R.id.newsFeedMenu)).perform(click());
        //verify newsfeed is displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        onView(withId(R.id.rv)).perform(swipeUp());
    }

    @Test
    public void addComment(){
        onView(withId(R.id.newsFeedMenu)).perform(click());
        //verify newsfeed is displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.commentTxt),isDisplayed())).perform(typeText("Woah! That's crazy"));
        closeSoftKeyboard();
    }

    @Test
    public void likeHeadline(){
        onView(withId(R.id.newsFeedMenu)).perform(click());
        //verify newsfeed is displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.like_button), isDisplayed())).perform(click());
    }

    @Test
    public void dislikeHeadline(){
        onView(withId(R.id.newsFeedMenu)).perform(click());
        //verify newsfeed is displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.dislike_button), isDisplayed())).perform(click());
    }
}
