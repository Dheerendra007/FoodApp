package com.dk.foodapp.api

import com.dk.foodapp.models.Meals
import retrofit2.Response
import retrofit2.http.GET

interface  MealService {

    @GET("json/v1/1/search.php?f=s")
    suspend fun getMeal() : Response<Meals>
}