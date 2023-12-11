package com.example.myrecyclerview.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.OnItemClickListener
import com.example.myrecyclerview.R
import com.example.myrecyclerview.databinding.ActivityMainBinding
import com.example.myrecyclerview.model.City
import com.example.myrecyclerview.model.Singleton

class MainActivity : AppCompatActivity() {
    lateinit var cityAdapter: CityAdapter
    var counter = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        Singleton.cities.add(City("Rouen",200000L))
        Singleton.cities.add(City("Paris",2000000L))
        Singleton.cities.add(City("Rio de Janeiro",10000000L))
        Singleton.cities.add(City("New York",5000000L))
        cityAdapter = CityAdapter(clickListener = object:OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Singleton.cities[position].apply {
                    name = name + "clicked"
                    cityAdapter.notifyItemChanged(position)
                }
            }
            override fun onItemLongClick(view: View, position: Int) {
                Singleton.cities.removeAt(position)
                cityAdapter.notifyItemRemoved(position)
            }
        })
        binding.recyclerView.adapter = cityAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.buttonAdd.setOnClickListener {
            Singleton.cities.add(City("City "+counter,counter))
            counter++
            cityAdapter.notifyItemInserted(Singleton.cities.size-1)
        }
    }
}