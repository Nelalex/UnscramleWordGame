package com.nelalexxx.unscramlewordgame

import com.nelalexxx.unscramlewordgame.data.repositories.GameData
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModel
import com.nelalexxx.unscramlewordgame.ui.fragments.game.GameUiState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class GameViewModelTest {
    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(repository = FakeRepository())
    }

    // CorrectWord
    @Test
    fun caseNumber1() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "hello".reversed(),
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "hello")
        expected = GameUiState.TextEdited()
        assertEquals(expected, actual)

        actual = viewModel.check("hello")
        expected = GameUiState.CorrectWord
        assertEquals(expected, actual)

        actual = viewModel.goNextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "spam".reversed(),
        )
        assertEquals(expected, actual)
    }

    // InCorrectWord
    @Test
    fun caseNumber2() {

        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "hello".reversed(),
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "ello")
        expected = GameUiState.TextEdited()
        assertEquals(expected, actual)

        actual = viewModel.check("ello")
        expected = GameUiState.InCorrectWord
        assertEquals(expected, actual)

        actual = viewModel.goNextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "spam".reversed(),
        )
        assertEquals(expected, actual)
    }

    // check end of list
    @Test
    fun caseNumber3() {

        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "hello".reversed(),
        )
        assertEquals(expected, actual)

        repeat(5) {
            actual = viewModel.goNextWord()
        }
        expected = GameUiState.Empty
        assertEquals(expected, actual)

    }

    // New Game
    @Test
    fun caseNumber4() {

        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "hello".reversed(),
        )
        assertEquals(expected, actual)

        repeat(5) {
            actual = viewModel.goNextWord()
        }
        expected = GameUiState.Empty
        assertEquals(expected, actual)
    }

//    //testTryGetDataSuccess
//    @ExperimentalCoroutinesApi@Test
//    fun caseNumber5() {
//        // Создаем мок для репозитория
//        val repository = mockk<GameRepository>()
//
//        // Создаем мок для API
//        val api = mockk<WordsListApi>()
//
//        // Создаем ViewModel с мокированным репозиторием и API
//        val viewModel = GameViewModel(repository) // Передаем api в конструктор
//
//        // Мокируем ответ от API
//        val wordList = listOf("hello", "world")
//        coEvery { api.getWordsList() } returns Response.success(wordList)
//
//        var actual: LoadingUiState = LoadingUiState.Empty
//        // Вызываем tryGetData()
//        GlobalScope.launch(Dispatchers.IO) {
//            actual = viewModel.tryGetData()
//        }
//
//        // Проверяем результат
//        val expected = LoadingUiState.Success
//        assertEquals(expected, actual)
//
//        // Проверяем, что список слов был установлен в репозитории
//        verify { repository.setWordListFromApi(wordList) }
//    }
}

private class FakeRepository : GameRepository {

    private var gameData = GameData()

    init {
        var fakeWordList: MutableList<String> = mutableListOf(
            "hello",
            "spam",
            "report",
            "stop",
            "troll"
        )
        gameData.originalList = fakeWordList
    }

    override fun setWordListFromApi(uploadedWordList: List<String>) {
        gameData.originalList = uploadedWordList.toMutableList()
    }

    override fun same(text: String): Boolean {
        return if (gameData.originalList[gameData.index].equals(text, true)) {
            gameData.correctAnswers++
            true
        } else
            false
    }

    override fun next(): Boolean {
        gameData.index++
        return if (gameData.index == gameData.originalList.size) {
            gameData.index = 0
            false
        } else
            true
    }

    override fun getCorrectAnswers(): Int {
        return gameData.correctAnswers
    }

    override fun shuffledWord(): String {
        if (gameData.index == 0) {
            gameData.correctAnswers = 0
        }
        return gameData.originalList[gameData.index].reversed()
    }
}




