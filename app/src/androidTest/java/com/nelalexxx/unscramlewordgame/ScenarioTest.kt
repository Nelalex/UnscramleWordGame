package com.nelalexxx.unscramlewordgame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nelalexxx.unscramlewordgame.game.GamePage
import com.nelalexxx.unscramlewordgame.ui.activities.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java) // Какой активити запускать

    private  lateinit var gamePage: GamePage

    //    "hello",
//    "spam",
//    "report",
//    "stop",
//    "troll"
    @Before
    fun setup() {
        gamePage = GamePage(word = "hello".reversed()) // education
    }

    /** UGTC-01
     *
     */
    @Test
    fun caseNumber1() {
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(text = "example")
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertCorrectWordState()

        gamePage.clickGetNextWordButton()
        gamePage = GamePage(word = "spam".reversed() /*example*/)
        gamePage.assertScrambleWordReceivedState()

    }

    /** UGTC-02
     *
     */
    fun caseNumber2() {
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(text = "d")
        gamePage.assertInputFieldEditedState()

        gamePage.editInputField(text = "e")
        gamePage.assertInputFieldEditedState()

        gamePage.editInputField(text = "")
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(text = "spam".reversed())
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertInCorrectWordState()

        gamePage.editInputField(text = "report".reversed())
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertCorrectWordState()

        gamePage.clickGetNextWordButton()
        gamePage = GamePage(word = "stop".reversed() /*example*/)
        gamePage.assertScrambleWordReceivedState()
    }

    /** UGTC-03
     *
     */
    fun caseNumber3() {
        gamePage.assertScrambleWordReceivedState()

        gamePage.clickGetNextWordButton()
        gamePage = GamePage(word = "etts" /*test*/)
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(text = "ttes")
        gamePage.assertInputFieldEditedState()

        gamePage.clickGetNextWordButton()
        gamePage = GamePage(word = "ricytov" /*victory*/)
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(text = "vyctori")
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertInCorrectWordState()

        gamePage.clickGetNextWordButton()
        gamePage = GamePage(word = "den" /*end*/)
        gamePage.assertScrambleWordReceivedState()
    }

    /*
    @Test
    fun caseNumber5() {
        gamePage.editInputField(text = "spasibo")
        gamePage.editInputField(text = "-2")

    }
    */


}