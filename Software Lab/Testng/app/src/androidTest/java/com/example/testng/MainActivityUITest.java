package com.example.testng;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testShapeAndColorInfoDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.shapeInfoTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Shape Information:\n" +
                        "Circle - Area: 75.0, Perimeter: 30.0\n" +
                        "Square - Area: 16.0, Perimeter: 16.0\n" +
                        "Triangle - Area: 6.0, Perimeter: 12.0")));

        Espresso.onView(ViewMatchers.withId(R.id.colorInfoTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Color Information:\n" +
                        "Red\n" +
                        "Blue\n" +
                        "Green")));
    }
}
