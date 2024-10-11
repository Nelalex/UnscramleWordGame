package com.nelalexxx.unscramlewordgame.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    val api: WordsListApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://random-word-api.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WordsListApi::class.java)
    }
}