package com.dk.foodapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.foodapp.models.Meals
import com.dk.foodapp.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MealRepository, val context: Context):ViewModel() {

   // var lst = MutableLiveData<ArrayList<Meals>>()
/*    //var newlist = arrayListOf<String>()


    fun getData() : MutableLiveData<ArrayList<String>> {
      lst.value=
        return   lst
    }*/
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMealRes()
        }
    }

    fun updateData(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMealRes()
        }
    }

    val mealsList : LiveData<Meals>
        get() = repository.mealServiceData
}