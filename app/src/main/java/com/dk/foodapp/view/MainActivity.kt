package com.dk.foodapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dk.foodapp.R
import com.dk.foodapp.api.MealService
import com.dk.foodapp.api.RetrofitHelper
import com.dk.foodapp.databinding.ActivityMainBinding
import com.dk.foodapp.models.Student

import com.dk.foodapp.repository.MealRepository
import com.dk.foodapp.viewmodel.MainViewModel
import com.dk.foodapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    private var viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val mealService = RetrofitHelper.getInstance().create(MealService::class.java)
        val repository = MealRepository(mealService)
        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(repository,application)
        ).get(MainViewModel::class.java)
        
        initialiseAdapter()
    }

    private fun initialiseAdapter(){
        binding.recyclerMeal.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        mainViewModel.mealsList.observe(this, Observer {
            binding.recyclerMeal.adapter= MealListAdapter(mainViewModel, it.meals, this)
        })
       /* dogsImageLoadListViewModel.dogImgsList.observe(this, Observer {
            binding.recyclerview.adapter= DogImageListAdapter(dogsImageLoadListViewModel, it, this)
        })*/
    }
}