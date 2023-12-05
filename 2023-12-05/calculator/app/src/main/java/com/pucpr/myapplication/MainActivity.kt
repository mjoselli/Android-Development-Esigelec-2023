package com.pucpr.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var editTextFirstNumber:EditText
    lateinit var editTextSecondNumber:EditText
    lateinit var buttonPlus:Button
    lateinit var textViewResult:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextFirstNumber = findViewById(R.id.editTextFirstNumber)
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber)
        buttonPlus = findViewById(R.id.buttonPlus)
        textViewResult = findViewById(R.id.textViewResult)
        buttonPlus.setOnClickListener{
            Log.d("Calculator","plus pressed")
            val num1 = editTextFirstNumber.text.toString().toDouble()
            val num2 = editTextSecondNumber.text.toString().toDouble()
            val result = num1 + num2
            textViewResult.text = "Result: $result"

        }
    }

}