package com.nelalexxx.unscramlewordgame.data.repositories

interface GameRepository {

    fun setWordListFromApi(uploadedWordList: List<String>)
    fun shuffledWord(): String
    fun same(text: String): Boolean
    fun next(): Boolean
    fun getCorrectAnswers(): Int
}
