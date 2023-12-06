package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.window.OnBackInvokedDispatcher

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        var information = intent.getStringExtra("info")
        findViewById<TextView>(R.id.textViewThirdActvity).text = information
        findViewById<Button>(R.id.buttonThirdActivity).apply {
            setOnClickListener {
                val intent = Intent()
                information += " very cool"
                intent.putExtra("third",information)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }



}