package com.example.listapp.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.listapp.R
import com.example.listapp.databinding.ActivityEditBinding
import com.example.listapp.model.Singleton

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityEditBinding>(this,
            R.layout.activity_edit
        )
        binding.editTextItem.setText(Singleton.arrayList[Singleton.itemClicked])
        binding.buttonSave.apply {
            text = "Save"
            setOnClickListener {
                Singleton.arrayList[Singleton.itemClicked] = binding.editTextItem.text.toString()
                finish()
            }
        }
    }
}