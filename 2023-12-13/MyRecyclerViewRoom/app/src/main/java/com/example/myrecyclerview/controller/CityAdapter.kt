package com.example.myrecyclerview.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.OnItemClickListener
import com.example.myrecyclerview.databinding.ViewItemBinding
import com.example.myrecyclerview.model.City
import com.example.myrecyclerview.model.Singleton

class CityAdapter(val clickListener: OnItemClickListener) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    inner class ViewHolder(val binding:ViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(city: City){
            binding.textViewName.text = city.name
            binding.textViewPopulation.text = "${city.population}"
            binding.root.setOnClickListener {
                clickListener.onItemClick(it,adapterPosition)
            }
            binding.root.setOnLongClickListener {
                clickListener.onItemLongClick(it,adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Singleton.cities[position].apply {
            holder.bind(this)
        }
    }
    override fun getItemCount() = Singleton.cities.size

}