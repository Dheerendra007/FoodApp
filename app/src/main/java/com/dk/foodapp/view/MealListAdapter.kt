package com.dk.foodapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dk.foodapp.R
import com.dk.foodapp.models.Meal
import com.dk.foodapp.viewmodel.MainViewModel
import org.w3c.dom.Text

class MealListAdapter(val viewModel: MainViewModel,
                      val arrayList: List<Meal>, val context: Context
): RecyclerView.Adapter<MealListAdapter.
NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MealListAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_meal,parent,false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: MealListAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.reversed().get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
        }else{

        }
        return arrayList.size
    }

    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(meal: Meal){
            Glide
                .with(context)
                .load(meal.strMealThumb)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(binding.findViewById(R.id.ivMealImage));
            binding.findViewById<TextView>(R.id.tv_Title).text = meal.strMeal
            binding.findViewById<TextView>(R.id.tv_Details).text = meal.strInstructions
        }
    }

}