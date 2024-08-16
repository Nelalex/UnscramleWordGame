package com.nelalexxx.unscramlewordgame

import org.junit.Assert.*
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
        viewModel = GameViewModel()
    }

    /*
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.AskedQuestion(
            question = "q1",
            choices = listOf("c1", "c2", "c3", "c4")
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseFirst()
        expected = GameUiSate.ChoiceMade(
        question = "q1",
        choices = listOf<ChoiceUiState>(
        ChoiceUiState.NotAvailableToChoose(text = "c1"),
        ChoiceUiState.AvailableToChoose(text = "c2"),
        ChoiceUiState.AvailableToChoose(text = "c3"),
        ChoiceUiState.AvailableToChoose(text = "c4")
        )
        )
        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = GameUiState.AnswerChecked(
        question = "q1",
        choices = listOf(
        ChoiceUiState.Correct(text = "c1"),
        ChoiceUiState.NotAvailableToChoose(text = "c2"),
        ChoiceUiState.NotAvailableToChoose(text = "c3"),
        ChoiceUiState.NotAvailableToChoose(text = "c4"),
        )
        )
        assertEquals(expected, actual)
    */


    @Test
    fun caseNumber1() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "123")
        expected = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = "123"
        )
        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = GameUiState.CorrectWord(
            text = "123".reversed(),
            inputFieldText = "123"
        )
        assertEquals(expected, actual)

        actual = viewModel.nextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "345".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)
    }

    @Test
    fun caseNumber2() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "3")
        expected = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = "3"
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "32")
        expected = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = "32"
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "")
        expected = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "321")
        expected = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = "321"
        )
        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = GameUiState.InCorrectWord(
            text = "123".reversed(),
            inputFieldText = "321"
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "123")
        expected = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = "123"
        )
        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = GameUiState.CorrectWord(
            text = "123".reversed(),
            inputFieldText = "123"
        )
        assertEquals(expected, actual)

        actual = viewModel.nextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "345".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)
    }

    @Test
    fun caseNumber3() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.ScrambleWordReceived(
            text = "123".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

        actual = viewModel.nextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "345".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "333")
        expected = GameUiState.ScrambleWordReceived(
            text = "345".reversed(),
            inputFieldText = "333"
        )
        assertEquals(expected, actual)

        actual = viewModel.nextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "789".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

        actual = viewModel.editInputField(text = "788")
        expected = GameUiState.ScrambleWordReceived(
            text = "789".reversed(),
            inputFieldText = "788"
        )
        assertEquals(expected, actual)

        actual = viewModel.check()
        expected = GameUiState.InCorrectWord(
            text = "789".reversed(),
            inputFieldText = "788"
        )
        assertEquals(expected, actual)

        actual = viewModel.nextWord()
        expected = GameUiState.ScrambleWordReceived(
            text = "024".reversed(),
            inputFieldText = ""
        )
        assertEquals(expected, actual)

    }
}




