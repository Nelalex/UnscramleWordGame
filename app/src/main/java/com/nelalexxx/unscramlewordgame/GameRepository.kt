package com.nelalexxx.unscramlewordgame

interface GameRepository {

    fun shuffledWord(): String
    fun same(text: String): Boolean
    fun next(): Boolean
    fun getCorrectAnswers(): Int


    class Base(
        private var index: StringCache,
        private var correctAnswers: StringCache,
        private val originalList: List<String> = listOf(
            "hello",
            "spam",
            "report",
            "stop",
            "troll"
        )
    ) : GameRepository {


        override fun same(text: String) =
            if (originalList[index.read().toInt()].equals(text, true)) {
                correctAnswers.save((correctAnswers.read().toInt() + 1).toString())
                true
            } else
                false


        override fun next(): Boolean {
            index.save((index.read().toInt() + 1).toString())
            return if (index.read().toInt() == originalList.size) {
                index.save("0")
                false
            } else
                true
        }

        override fun getCorrectAnswers(): Int = correctAnswers.read().toInt()


        override fun shuffledWord(): String {
            if (index.read().toInt() == 0) {
                correctAnswers.save("0")
            }
            return originalList[index.read().toInt()].reversed()
        }
    }
}
