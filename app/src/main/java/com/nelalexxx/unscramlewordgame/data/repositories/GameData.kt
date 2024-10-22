package com.nelalexxx.unscramlewordgame.data.repositories

data class GameData(
    var index: Int = 0,
    var correctAnswers: Int = 0,
    var originalList: MutableList<String> = mutableListOf(""),

)