package com.nelalexxx.unscramlewordgame

// Основной класс для работы с данными
class GameViewModel(private val repository: GameRepository) {


    fun getCorrectAnswers() = repository.getCorrectAnswers()
    // функция срабатывает при нажатии кнопки check
    // получает на вход строку(из EditText) и в зависимости от значения
    // выбирает какое преобразование с экраном выполнить

    fun check(text: String): GameUiState = if (repository.same(text))
        GameUiState.CorrectWord
    else
        GameUiState.InCorrectWord



    // функция получает на вход
    fun goNextWord(): GameUiState = if (repository.next())
        init()
    else
        GameUiState.Empty


    fun init(firstRun: Boolean = true): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

    //
    fun editInputField(text: String): GameUiState = if (text == "")
        GameUiState.TextEdited(-1)
    else
        GameUiState.TextEdited()


    fun nextWord(): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

}
