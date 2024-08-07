package com.nelalexxx.unscramlewordgame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java) // Какой активити запускать

    private  lateinit var gamePage: GamePage

    @Before
    fun setup() {
        gamePage = GamePage(word = "ionucedat") // education
    }

    /** UGTC-01
     *
     */
    @Test
    fun caseNumber1() {
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField("example")
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertCorrectWordState()

        gamePage.clickNext()
        gamePage = GamePage(word = "xepleam" /*example*/)
        gamePage.assertScrambleWordReceivedState()

    }

    /** UGTC-02
     *
     */
    fun caseNumber2() {
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(word = "d")
        gamePage.assertInputFieldEditedState()

        gamePage.editInputField(word = "e")
        gamePage.assertInputFieldEditedState()

        gamePage.editInputField(word = "")
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField(word = "educatoin")
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertInCorrectWordState()

        gamePage.editInputField(word = "education")
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertCorrectWordState()

        gamePage.clickNext()
        gamePage = GamePage(word = "xepleam" /*example*/)
        gamePage.assertScrambleWordReceivedState()
    }

    /** UGTC-03
     *
     */
    fun caseNumber3() {
        gamePage.assertScrambleWordReceivedState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "etts" /*test*/)
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField("ttes")
        gamePage.assertInputFieldEditedState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "ricytov" /*victory*/)
        gamePage.assertScrambleWordReceivedState()

        gamePage.editInputField("vyctori")
        gamePage.assertInputFieldEditedState()

        gamePage.clickCheck()
        gamePage.assertInCorrectWordState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "den" /*end*/)
        gamePage.assertScrambleWordReceivedState()
    }


}