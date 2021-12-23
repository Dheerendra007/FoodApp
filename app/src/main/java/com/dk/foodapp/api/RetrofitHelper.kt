package com.dk.foodapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

  //  https://www.themealdb.com/api/json/v1/1/search.php?f=s
    private const val BASE_URL = "https://www.themealdb.com/api/"

    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).build()
    }
}