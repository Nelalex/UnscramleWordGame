package com.nelalexxx.unscramlewordgame.stats

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.game.ButtonUi
import org.hamcrest.Matcher

class StatsPage(correctAnswers: Int) {

    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.loadingLayout))
    private val classTypeMatcher: Matcher<View> =
        withParent(isAssignableFrom(LinearLayout::class.java))

    private val statsUI = StatsUi(
        correctAnswers = correctAnswers,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val newGameButtonUi = ButtonUi(
        id = R.id.newGameButton,
        textResId = R.string.start_new_game,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    fun assertStatsPage() {
        statsUI.assertVisibleState()
    }

    fun clickNewGameButton() {
        newGameButtonUi.click()
    }


}
