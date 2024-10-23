package com.nelalexxx.unscramlewordgame.loading

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.game.ButtonUi
import org.hamcrest.Matcher

class LoadingPage {

    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.statsLayout))
    private val classTypeMatcher: Matcher<View> =
        withParent(isAssignableFrom(ConstraintLayout::class.java))

    private val errorTVUI = ErrorTV(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val retryConnectBtnUI = ButtonUi(
        id = R.id.retryConnectBtn,
        textResId = R.string.retry,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    private val loadProgressBarUI = LoadProgressBarUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = classTypeMatcher
    )

    fun retryConnectBtnClick() {
        retryConnectBtnUI.click()
    }

    fun assertAttemptToConnectState() {
        retryConnectBtnUI.assertInvisibleState()
        errorTVUI.assertInvisibleState()
        loadProgressBarUI.assertVisibleState()

    }

    fun assertConnectionErrorState() {
        retryConnectBtnUI.assertVisibleState()
        errorTVUI.assertVisibleState()
        loadProgressBarUI.assertInvisibleState()
    }

}