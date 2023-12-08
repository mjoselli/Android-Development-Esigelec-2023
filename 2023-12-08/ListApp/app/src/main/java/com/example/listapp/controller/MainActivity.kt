package com.example.listapp.controller

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.listapp.R
import com.example.listapp.databinding.ActivityMainBinding
import com.example.listapp.model.Singleton

class MainActivity : AppCompatActivity() {

    var counter = 4
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        binding.button.text = "Add Item"
        binding.button.setOnClickListener {
            Singleton.arrayList.add("item $counter")
            adapter.notifyDataSetChanged()
            counter++
        }
        val mainListView = binding.mainListView
        adapter = ArrayAdapter<String>(this,
                                            android.R.layout.simple_list_item_1,
                                            Singleton.arrayList)
        mainListView.adapter = adapter
        mainListView.setOnItemClickListener { parent, view, position, id ->
            Singleton.itemClicked = position
            view.setBackgroundColor(Color.GRAY)

            var intent = Intent(this@MainActivity, EditActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}