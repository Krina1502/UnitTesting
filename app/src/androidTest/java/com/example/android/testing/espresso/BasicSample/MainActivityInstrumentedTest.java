package com.example.android.testing.espresso.BasicSample;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Test
    public void validateCorrectStringsInTextView_MainActivity() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.textToBeChanged))
                .check(ViewAssertions.matches(withText("")));
    }

    @Test
    public void testChangeTextButton_withInput() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        Espresso.onView(withId(R.id.changeTextBt)).perform(click());

        Espresso.onView(withId(R.id.textToBeChanged))
                .check(ViewAssertions.matches(withText("123")));
    }

    @Test
    public void testChangeTextButton_withoutInput() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.changeTextBt)).perform(click());

        Espresso.onView(withId(R.id.textToBeChanged))
                .check(ViewAssertions.matches(withText("")));
    }

    @Test
    public void testOpenActivity_withInput() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click());

        Espresso.onView(withId(R.id.show_text_view))
                .check(ViewAssertions.matches(withText("123")));
    }

    @Test
    public void testOpenActivity_withoutInput() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click());

        Espresso.onView(withId(R.id.show_text_view))
                .check(ViewAssertions.matches(withText("")));
    }

    @Test
    public void testChangeTextButton_withAlphabetInput() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        Espresso.onView(withId(R.id.changeTextBt)).perform(click());

        Espresso.onView(withId(R.id.textToBeChanged))
                .check(ViewAssertions.matches(withText("abcdef")));
    }

    @Test
    public void testOpenActivity_withAlphabetInput() {
        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click());

        Espresso.onView(withId(R.id.show_text_view))
                .check(ViewAssertions.matches(withText("abcdef")));
    }


}
