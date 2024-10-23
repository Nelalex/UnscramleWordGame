package com.nelalexxx.unscramlewordgame.game

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.nelalexxx.unscramlewordgame.R
import org.hamcrest.Matcher

class GamePage(word: String) {

    private val containerIdMatcher: Matcher<View> = withId(R.id.gameFragmentLayout)
    private val classTypeMatcher: Matcher<View> = isAssignableFrom(LinearLayout::class.java)

    private val wordUi = WordUi(
        text = word,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val inputField = InputField(
        id = R.id.inputFieldLayout,
            containerIdMatcher = containerIdMatcher,
        )

    private val checkButtonUi = ButtonUi(
        id = R.id.checkButton,
        textResId = R.string.checkButtonText,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val getNextWordButtonUi = ButtonUi(
        id = R.id.getNextWordButton,
        textResId = R.string.skip, // skip - next
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )


    fun editInputField(text: String) {
        inputField.onTextChange(text = text)
    }

    fun clickCheck() {
        checkButtonUi.click()
    }

    fun clickGetNextWordButton() {
        getNextWordButtonUi.click()
    }

    fun assertScrambleWordReceivedState() {
        wordUi.assertTextVisible()
        inputField.assertScrambleWordReceivedState()
        checkButtonUi.assertInvisibleState()
        // checkButtonUi.assertDisabledState()
        getNextWordButtonUi.assertScrambleWordReceivedState()
    }

    fun assertInputFieldEditedState() {
        wordUi.assertTextVisible()
        inputField.assertInputFieldEditedState()
        checkButtonUi.assertVisibleState()
        // checkButtonUi.assertEnabledState()
        getNextWordButtonUi.assertInputFieldEditedState()
    }

    fun assertCorrectWordState() {
        wordUi.assertTextVisible()
        inputField.assertCorrectWordState()
        checkButtonUi.assertInvisibleState()
        getNextWordButtonUi.assertCorrectWordState()
    }

    fun assertInCorrectWordState() {
        wordUi.assertTextVisible()
        inputField.assertInCorrectWordState()
        checkButtonUi.assertInvisibleState()
        //  checkButtonUi.assertDisabledState()
        getNextWordButtonUi.assertInCorrectWordState()
    }
}