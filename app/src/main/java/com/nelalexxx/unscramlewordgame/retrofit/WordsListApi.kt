package com.nelalexxx.unscramlewordgame.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface WordsListApi {

    @GET("/api?words=10")
    suspend fun getWordsList(): Response<List<String>>
}