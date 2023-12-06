package com.example.intents

import android.app.Instrumentation.ActivityResult
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    var information = "information"

    val resultLauncher = registerForActivityResult(
                            ActivityResultContracts.StartActivityForResult()
                            ){
        if(it.resultCode == RESULT_OK){
            val result = it.data?.getStringExtra("third")
            findViewById<TextView>(R.id.textViewSecondActivity).apply {
                text = result
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.buttonSecondActivity).apply {
            setOnClickListener {
                val builder = AlertDialog.Builder(this@SecondActivity)
                builder.setTitle("Alert")
                builder.setMessage("Do you want to go to third activity?")
                builder.setPositiveButton(android.R.string.yes) { dialog, i ->
                    information = "yes"
                    goToThirdActivity()
                }
                builder.setNegativeButton(android.R.string.no){ dialog, i ->
                    Toast.makeText(this@SecondActivity,"ohhh no!",Toast.LENGTH_LONG)
                        .show()
                }
                builder.setNeutralButton("Maybe"){ dialog, i ->
                    information = "maybe"
                    val snackbar = Snackbar.make(this@SecondActivity.findViewById(R.id.main),
                                                    "you cqn go now", Snackbar.LENGTH_LONG)
                    snackbar.setAction("Yes") {
                        goToThirdActivity()
                    }
                    snackbar.show()
                }
                builder.show()
            }
        }
    }
    fun goToThirdActivity(){
        val intent = Intent(this@SecondActivity,
            ThirdActivity::class.java)
        intent.putExtra("info",information)
        //startActivity(intent)
        resultLauncher.launch(intent)
    }
}