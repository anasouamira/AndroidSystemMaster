package com.anasouamira.androidsystemmaster.uitests

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anasouamira.androidsystemmaster.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkButtonsDisplayed() {
        Espresso.onView(ViewMatchers.withText("Asynchronisme"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("WorkManager"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun clickAsyncButton_navigatesToAsyncScreen() {
        Espresso.onView(ViewMatchers.withText("Asynchronisme"))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("State: Idle"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
