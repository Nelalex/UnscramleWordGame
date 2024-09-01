package com.nelalexxx.unscramlewordgame

interface GameRepository {

    fun shuffledWord(): String
    fun same(): Boolean
    fun next()


    class Base(
        private var index: StringCache,
        private var userInput: StringCache,
        private val originalList: List<String> = listOf(
            "hello",
            "spam",
            "report",
            "stop",
            "troll"
        )
    ) : GameRepository {


        override fun same(): Boolean =
            originalList[index.read().toInt()].equals(userInput.read(), true)

        override fun next() {
            index.save((index.read().toInt() + 1).toString())
            if (index.read().toInt() == originalList.size)
                index.save("0")
        }

        override fun shuffledWord() = originalList[index.read().toInt()].reversed()

    }
}
