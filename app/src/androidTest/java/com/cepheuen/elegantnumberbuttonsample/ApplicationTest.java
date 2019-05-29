package com.cepheuen.elegantnumberbuttonsample;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.both;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void checkIfIncrementButtonChangesNumber() {
    onView(both(withResourceName("add_btn"))
        .and(withParent(withParent(withResourceName("number_button")))))
        .perform(click());
    onView(both(withResourceName("number_counter"))
        .and(withParent(withParent(withResourceName("number_button")))))
        .check(matches(withText("1")));
    onView(both(withResourceName("add_btn"))
        .and(withParent(withParent(withResourceName("number_button2")))))
        .perform(click());
    onView(both(withResourceName("number_counter"))
        .and(withParent(withParent(withResourceName("number_button2")))))
        .check(matches(withText("11")));

  }
}