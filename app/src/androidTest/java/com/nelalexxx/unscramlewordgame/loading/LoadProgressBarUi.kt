package com.nelalexxx.unscramlewordgame.loading

import android.view.View
import android.widget.ProgressBar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.nelalexxx.unscramlewordgame.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

class LoadProgressBarUi(
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.loadProgressBar),
            isAssignableFrom(ProgressBar::class.java)
        )
    )

    fun assertVisibleState() {
        interaction.check(matches(isDisplayed()))
    }

    fun assertInvisibleState() {
        interaction.check(matches(not(isCompletelyDisplayed())))
    }
}
