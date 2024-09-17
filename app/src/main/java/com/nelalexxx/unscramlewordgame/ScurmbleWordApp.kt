package com.nelalexxx.unscramlewordgame

import android.app.Application
import android.content.Context

class ScrumbleWordApp : Application() {

    lateinit var viewModel: GameViewModel
    override fun onCreate() {
        super.onCreate()


        val sharedPreferences = getSharedPreferences("scrWordData", Context.MODE_PRIVATE)
        viewModel = GameViewModel(
            GameRepository.Base(
                StringCache.Base(sharedPreferences, "indexKey", "0"),
                StringCache.Base(sharedPreferences, "correctAnswers", "0")
            )
        )




    }


}