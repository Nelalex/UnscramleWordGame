package com.nelalexxx.unscramlewordgame.game

import android.util.Log
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.nelalexxx.unscramlewordgame.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

class InputField(
    id: Int,
    containerClassTypeMatcher: Matcher<View>,
    containerIdMatcher: Matcher<View>
) {

    private val layoutInteraction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.inputFieldLayout),
            isAssignableFrom(TextInputLayout::class.java)
        )
    )

    private val inputInteraction: ViewInteraction = onView(
        allOf(
            withId(R.id.inputFieldEditText),
            isAssignableFrom(TextInputEditText::class.java),
            withParent(withId(R.id.inputFieldLayout)),
            withParent(isAssignableFrom(TextInputLayout::class.java))
        )
    )


    fun onTextChange(text: String) {
        val newText = if (text.startsWith("-")) {
            // Удаляем символы из текста
            val currentText = getText(withId(R.id.inputFieldEditText))
            val numCharsToRemove = text.substring(1).toIntOrNull() ?: 0
            currentText.dropLast(numCharsToRemove)
        } else {
            // Добавляем текст
            val currentText = getText(withId(R.id.inputFieldEditText))
            currentText + text
        }

        onView(withId(R.id.inputFieldEditText)).perform(replaceText(newText))
        onView(withId(R.id.inputFieldEditText)).check(matches(withText(newText)))
        Log.d("EspressoTest", "Значение параметра: $newText")
    }

    // Вспомогательная функция для получения текста из View
    private fun getText(matcher: Matcher<View>): String {
        val stringHolder = arrayOf<String>("")
        onView(matcher).perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextInputEditText::class.java)
            }

            override fun getDescription(): String {
                return "getting text from a EditText"
            }

            override fun perform(uiController: UiController, view: View) {
                val editText = view as TextInputEditText
                stringHolder[0] = editText.text.toString()
            }
        })
        return stringHolder[0]
    }


    fun assertScrambleWordReceivedState() {
        layoutInteraction.check(matches(isEnabled()))
        inputInteraction.check(matches(withText("")))
    }

    fun assertInputFieldEditedState() {
        layoutInteraction.check(matches(isEnabled()))
    }

    fun assertCorrectWordState() {
        layoutInteraction.check(matches(not(isEnabled())))
    }

    fun assertInCorrectWordState() {
        layoutInteraction.check(matches(isEnabled()))
    }

}
