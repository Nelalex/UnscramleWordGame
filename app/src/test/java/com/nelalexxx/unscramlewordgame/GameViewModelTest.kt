package com.nelalexxx.unscramlewordgame

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//class GameViewModelTest {
//
//    private lateinit var viewModel: GameViewModel
//
//    @Before
//    fun setup() {
//        viewModel = GameViewModel(repository = FakeRepository())
//    }

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


//
//    @Test
//    fun caseNumber1() {
//        var actual: GameUiState = viewModel.init()
//        var expected: GameUiState = GameUiState.ScrambleWordReceived(
//            text = "123".reversed(),
//        )
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "123")
//        expected = GameUiState.ScrambleWordReceived(
//            text = "123".reversed(),
//        )
//        assertEquals(expected, actual)
//
//        actual = viewModel.check("123")
//        expected = GameUiState.CorrectWord
//        assertEquals(expected, actual)
//
//        actual = viewModel.nextWord()
//        expected = GameUiState.ScrambleWordReceived(
//            text = "345".reversed(),
//        )
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun caseNumber2() {
//        var actual: GameUiState = viewModel.init()
//        var expected: GameUiState = GameUiState.ScrambleWordReceived(
//            text = "123".reversed(),
//        )
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "3")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "32")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "321")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.check("222")
//        expected = GameUiState.InCorrectWord
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "123")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.check("123")
//        expected = GameUiState.CorrectWord
//        assertEquals(expected, actual)
//
//        actual = viewModel.nextWord()
//        expected = GameUiState.ScrambleWordReceived("642".reversed())
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun caseNumber3() {
//        var actual: GameUiState = viewModel.init()
//        var expected: GameUiState = GameUiState.ScrambleWordReceived(text = "123".reversed())
//        assertEquals(expected, actual)
//
//        actual = viewModel.nextWord()
//
//        expected = GameUiState.ScrambleWordReceived("345".reversed())
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "333")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.nextWord()
//        expected = GameUiState.ScrambleWordReceived(text = "789".reversed())
//        assertEquals(expected, actual)
//
//        actual = viewModel.editInputField(text = "788")
//        expected = GameUiState.TextEdited()
//        assertEquals(expected, actual)
//
//        actual = viewModel.check(text = "788")
//        expected = GameUiState.InCorrectWord
//        assertEquals(expected, actual)
//
//        actual = viewModel.nextWord()
//        expected = GameUiState.ScrambleWordReceived(text = "024".reversed())
//        assertEquals(expected, actual)
//
//    }
//}
//
// */
//    private class FakeRepository : GameRepository {
//
//        private var gameData = GameData()
//    var fakeWordList: MutableList<String> = mutableListOf(
//        "hello",
//        "spam",
//        "report",
//        "stop",
//        "troll"
//    )
//
//        override fun setWordListFromApi(uploadedWordList: List<String>) {
//            gameData.originalList = fakeWordList
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
//}



