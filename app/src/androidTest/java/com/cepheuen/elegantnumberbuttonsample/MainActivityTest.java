package com.cepheuen.elegantnumberbuttonsample;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.Espresso;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {
    @Rule public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class,
            false, true);
    private MainActivity activity;

    @Before
    public void get_activity() { activity = rule.getActivity(); }

    @Test
    public void test_add_button_click() {
        try {
            // Change btn1 text to find it with ViewMatchers
            rule.runOnUiThread(() -> activity.btn1.addBtn.setText("target"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Espresso.onView(allOf(withId(R.id.add_btn), withText("target"))).perform(click());
        assertThat(activity.btn1.getNumber(), Matchers.is("1"));
    }

    @Test
    public void test_set_number() {
        try {
            rule.runOnUiThread(() -> activity.btn1.setNumber("3", true /*notify listeners*/));
            rule.runOnUiThread(() -> activity.btn1.setNumber("1", false /*don't notify*/));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        assertThat(activity.textView.getText(), is("3"));
    }
}
