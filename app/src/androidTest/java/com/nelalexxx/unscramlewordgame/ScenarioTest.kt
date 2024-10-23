package com.nelalexxx.unscramlewordgame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nelalexxx.unscramlewordgame.game.GamePage
import com.nelalexxx.unscramlewordgame.stats.StatsPage
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
        gamePage = GamePage(word = "hello") // education
    }

    /** UGTC-01
     *
     */
    @Test
    fun caseNumber1() {

        activityScenarioRule.doWithRecreate(gamePage::assertScrambleWordReceivedState)

        gamePage.editInputField(text = "hello")
        activityScenarioRule.doWithRecreate(gamePage::assertInputFieldEditedState)

        gamePage.clickCheck()
        activityScenarioRule.doWithRecreate(gamePage::assertCorrectWordState)

        gamePage.clickGetNextWordButton()
        gamePage = GamePage(word = "spam" /*example*/)
        activityScenarioRule.doWithRecreate(gamePage::assertScrambleWordReceivedState)

        repeat(4) {
            gamePage.clickGetNextWordButton()
        }

        val statsPage = StatsPage(correctAnswers = 4)
        activityScenarioRule.doWithRecreate(statsPage::assertStatsPage)

        statsPage.clickNewGameButton()
        setup()
        activityScenarioRule.doWithRecreate(gamePage::assertScrambleWordReceivedState)
    }

    // Чтобы обновлять экран после каждого теста
    private fun ActivityScenarioRule<*>.doWithRecreate(block: () -> Unit) {
        block.invoke()
        scenario.recreate()
        block.invoke()
    }

//    private class FakeRepository : GameRepository {
//
//        private var gameData = GameData()
//
//        init {
//            var fakeWordList: MutableList<String> = mutableListOf(
//                "hello",
//                "spam",
//                "report",
//                "stop",
//                "troll"
//            )
//            gameData.originalList = fakeWordList
//        }
//
//
//        override fun setWordListFromApi(uploadedWordList: List<String>) {
//            gameData.originalList = uploadedWordList.toMutableList()
//        }
//
//        override fun same(text: String): Boolean {
//            return if (gameData.originalList[gameData.index].equals(text, true)) {
//                gameData.correctAnswers++
//                true
//            } else
//                false
//        }
//
//        override fun next(): Boolean {
//            gameData.index++
//            return if (gameData.index == gameData.originalList.size) {
//                gameData.index = 0
//                false
//            } else
//                true
//        }
//
//        override fun getCorrectAnswers(): Int {
//            return gameData.correctAnswers
//        }
//
//        override fun shuffledWord(): String {
//            if (gameData.index == 0) {
//                gameData.correctAnswers = 0
//            }
//            return gameData.originalList[gameData.index].reversed()
//        }
//    }
}