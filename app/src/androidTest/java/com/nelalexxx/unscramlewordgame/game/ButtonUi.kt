package com.nelalexxx.unscramlewordgame.game

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.nelalexxx.unscramlewordgame.ButtonColorMatcher
import com.nelalexxx.unscramlewordgame.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher


class ButtonUi(
    id: Int,
    textResId: Int,
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) : AbstractButton(
    onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(id),
            withText(textResId),
            isAssignableFrom(AppCompatButton::class.java)
        )
    )
) {

    fun assertVisibleState() {
        interaction.check(matches(isDisplayed()))
    }

    fun assertDisabledState() {
        interaction.check(matches(not(isEnabled())))
    }

    fun assertScrambleWordReceivedState() {
        interaction
            .check(matches(ButtonColorMatcher(R.color.skipButtonColor)))
            .check(matches(withText(R.string.skip)))
    }

    fun assertEnabledState() {
        interaction.check(matches(isEnabled()))
    }

    fun assertInvisibleState() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun assertCorrectWordState() {
        interaction
            .check(matches(ButtonColorMatcher(R.color.Correct)))
            .check(matches(withText(R.string.next)))
    }

    fun assertInputFieldEditedState() {
        interaction
            .check(matches(ButtonColorMatcher(R.color.Correct)))
            .check(matches(withText(R.string.skip)))
    }


    fun assertInCorrectWordState() {
        interaction
            .check(matches(ButtonColorMatcher(R.color.checkButtonColor)))
            .check(matches(withText(R.string.skip)))
    }

}

abstract class AbstractButton(
    protected val interaction: ViewInteraction
) {
    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }


}

