package com.nelalexxx.unscramlewordgame.data.repositories

interface GameRepository {

    var index: Int
    var correctAnswers: Int

    fun setWordListFromApi(uploadedWordList: List<String>)
    fun shuffledWord(): String
    fun same(text: String): Boolean
    fun next(): Boolean

    companion object Base : GameRepository {
        //        override val originalList  = listOf(
//            "hello",
//            "spam",
//            "report",
//            "stop",
//            "troll"
//        )
        private var originalList = mutableListOf<String>("error")
        override fun setWordListFromApi(uploadedWordList: List<String>) {
            originalList = uploadedWordList.toMutableList()
        }

        override var index: Int = 0
        override var correctAnswers: Int = 0


        override fun same(text: String) =
            if (originalList[index].equals(text, true)) {
                correctAnswers++
                true
            } else
                false

        override fun next(): Boolean {
            index++
            return if (index == originalList.size) {
                index = 0
                false
            } else
                true
        }

        override fun shuffledWord(): String {
            if (index == 0) {
                correctAnswers = 0
            }
            return originalList[index].reversed()
        }
    }
}
