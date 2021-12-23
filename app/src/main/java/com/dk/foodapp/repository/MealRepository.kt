package com.dk.foodapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dk.foodapp.api.MealService
import com.dk.foodapp.models.Meals

class MealRepository (private val mealService : MealService) {

    private val mealServiceLiveData = MutableLiveData<Meals>()

    val mealServiceData: LiveData<Meals>
        get() = mealServiceLiveData

    suspend fun getMealRes(){
        //call API service
        val result = mealService.getMeal()
        if (result?.body() != null){
            mealServiceLiveData.postValue(result.body())
        }
    }
}



