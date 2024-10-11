package com.nelalexxx.unscramlewordgame.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository

class GameViewModelFactory(private val repository: GameRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(repository) as T
        } else
            throw IllegalStateException("ERROR")
    }
}
