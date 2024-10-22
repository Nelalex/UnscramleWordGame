package com.nelalexxx.unscramlewordgame.data.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository
import com.nelalexxx.unscramlewordgame.retrofit.RetrofitInstance
import com.nelalexxx.unscramlewordgame.ui.fragments.game.GameUiState
import com.nelalexxx.unscramlewordgame.ui.fragments.loading.LoadingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withTimeoutOrNull
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

    fun init(): GameUiState {
        val data = repository.shuffledWord()
        return GameUiState.ScrambleWordReceived(data)
    }

    fun editInputField(text: String): GameUiState = if (text == "")
        GameUiState.TextEdited(-1)
    else
        GameUiState.TextEdited()

    // LoadingFragment
    private fun setWordListFromApi(wordList: List<String>) {
        repository.setWordListFromApi(wordList)
    }


    suspend fun tryGetData(): LoadingUiState {
        return withTimeoutOrNull(2000) { // Ожидание 2 секунды
            try {
                val response = RetrofitInstance().api.getWordsList()
                if (response.isSuccessful) {
                    setWordListFromApi(response.body()!!)
                    LoadingUiState.Success
                } else {
                    Log.d("LoadingFragment", "API error: ${response.code()}")
                    LoadingUiState.ConnectionError
                }
            } catch (e: Exception) {
                Log.d("LoadingFragment", "Network error: ${e.message}")
                LoadingUiState.ConnectionError
            }
        } ?: LoadingUiState.ConnectionError // Если время ожидания истекло
    }


}
