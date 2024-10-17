package com.nelalexxx.unscramlewordgame.data.repositories

import javax.inject.Inject

class GameRepositoryImpl @Inject constructor() : GameRepository {

    private var gameData = GameData()

    override fun setWordListFromApi(uploadedWordList: List<String>) {
        gameData.originalList = uploadedWordList.toMutableList()
    }

    override fun same(text: String): Boolean {
        return if (gameData.originalList[gameData.index].equals(text, true)) {
            gameData.correctAnswers++
            true
        } else
            false
    }

    override fun next(): Boolean {
        gameData.index++
        return if (gameData.index == gameData.originalList.size) {
            gameData.index = 0
            false
        } else
            true
    }

    override fun getCorrectAnswers(): Int {
        return gameData.correctAnswers
    }

    override fun shuffledWord(): String {
        if (gameData.index == 0) {
            gameData.correctAnswers = 0
        }
        return gameData.originalList[gameData.index].reversed()
    }
}