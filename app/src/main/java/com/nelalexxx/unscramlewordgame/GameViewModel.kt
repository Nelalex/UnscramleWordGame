package com.nelalexxx.unscramlewordgame

// Основной класс для работы с данными
class GameViewModel(private val repository: GameRepository) {

    // функция срабатывает при нажатии кнопки check
    // получает на вход строку(из EditText) и в зависимости от значения
    // выбирает какое преобразование с экраном выполнить
    fun check(text: String): GameUiState {

        val data = repository.shuffledWord()
        if (text == data.reversed()) {
            return GameUiState.CorrectWord
        } else {
            return GameUiState.InCorrectWord
        }
    }

    // функция получает на вход
    fun goNextWord(): GameUiState {
        repository.next()
        return init()
    }

    fun init(firstRun: Boolean = true): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

    //
    fun editInputField(text: String): GameUiState {
        return if (text == "") {
            GameUiState.TextEdited(-1)
        } else
            GameUiState.TextEdited()
    }

    fun nextWord(): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

}
