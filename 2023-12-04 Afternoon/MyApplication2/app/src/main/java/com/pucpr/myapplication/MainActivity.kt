package com.pucpr.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.editText)
        editText.setText("0")
    }
    //one line comment
    /*
    multi
    line
    comment
     */
    public fun buttonClicked(view:View){
        var number = editText.text.toString().toInt()
        number += 3
        editText.setText("$number")
        var textView = findViewById<TextView>(R.id.textView)
        textView.text = "Bye Esigelec: " + number
        if(number > 10 && number < 25){
            textView.text = "..."
        }else if(number < 25){
            textView.text = "Minor number "
        }


    }
}