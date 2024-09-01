package com.nelalexxx.unscramlewordgame

class GameViewModel(private val repository: GameRepository) {

    //
    fun check(text: String): GameUiState {

        val data = repository.shuffledWord()
        if (text == data.reversed()) {
            return GameUiState.CorrectWord()
        } else {
            return GameUiState.InCorrectWord()
        }
    }

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
        if (text == "") {
            val data = repository.shuffledWord()
            return GameUiState.TextEdited(-1)
        } else
            return GameUiState.TextEdited()
    }

    fun nextWord(): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

}
