package com.nelalexxx.unscramlewordgame.data.viewmodels

import androidx.lifecycle.ViewModel
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository

class GameViewModel(private val repository: GameRepository) : ViewModel() {

    lateinit var uiState: GameUiState
    fun getCorrectAnswers() = repository.correctAnswers

    fun check(text: String): GameUiState = if (repository.same(text))
        GameUiState.CorrectWord
    else
        GameUiState.InCorrectWord

    fun goNextWord(): GameUiState = if (repository.next()) {
        val data = repository.shuffledWord()
        GameUiState.ScrambleWordReceived(data)
    } else
        GameUiState.Empty

    fun init() {
        val data = repository.shuffledWord()
        uiState = GameUiState.ScrambleWordReceived(data)
    }

    fun editInputField(text: String): GameUiState = if (text == "")
        GameUiState.TextEdited(-1)
    else
        GameUiState.TextEdited()

    fun nextWord(): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

    fun setWordListFromApi(wordList: List<String>) {
        repository.setWordListFromApi(wordList)
    }
}
