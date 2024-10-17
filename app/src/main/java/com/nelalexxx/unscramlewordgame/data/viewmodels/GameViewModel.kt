package com.nelalexxx.unscramlewordgame.data.viewmodels

import androidx.lifecycle.ViewModel
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository
import com.nelalexxx.unscramlewordgame.ui.fragments.game.GameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GameRepository
) : ViewModel() {

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


    fun setWordListFromApi(wordList: List<String>) {
        repository.setWordListFromApi(wordList)
    }
}
