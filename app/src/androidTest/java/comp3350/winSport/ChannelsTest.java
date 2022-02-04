package comp3350.winSport;

import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.winSport.presentation.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class ChannelsTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        mainRule.getActivity();
        Intents.init();
    }

    @Test
    public void testIntentBrowser(){
        //uses stubbing via Espresso-intents to test whether intent to open browser was sent
        //without actually opening browser + guarantee that the link in strings.xml matches
        //the one in hasData
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://www.cbc.ca/sports"));
        onView(withId(R.id.channel_layout)).perform(click());
        //verify the channels are displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        onView(allOf(withId(R.id.name), withText("CBCSports"))).perform(click()); //click on CBCSports link
        intended(expectedIntent);
    }

    @Test
    public void viewChannel(){
        onView(withId(R.id.channel_layout)).perform(click());
        //verify the channels are displayed
        onView(allOf(withId(R.id.rv))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.name), withText("CBCSports"))).perform(click()); //click on CBCSports link
    }

    @After
    public void tearDown(){
        Intents.release();
    }
}
