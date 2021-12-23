package com.dk.foodapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dk.foodapp.repository.MealRepository

class MainViewModelFactory(private val repository: MealRepository, val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return MainViewModel(repository,context) as T
    }
}