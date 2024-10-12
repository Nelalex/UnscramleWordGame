package com.nelalexxx.unscramlewordgame.data.viewmodels

import androidx.lifecycle.ViewModel
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepositoryImpl
import com.nelalexxx.unscramlewordgame.ui.fragments.game.GameUiState

class GameViewModel(private val repository: GameRepositoryImpl) : ViewModel() {


    fun getCorrectAnswers() = repository.getCorrectAnswers()

    fun check(text: String): GameUiState = if (repository.same(text))
        GameUiState.CorrectWord
    else
        GameUiState.InCorrectWord

    fun goNextWord(): GameUiState = if (repository.next()) {
        val data = repository.shuffledWord()
        GameUiState.ScrambleWordReceived(data)
    } else
        GameUiState.Empty

    fun init(): String {
        return repository.shuffledWord()
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
