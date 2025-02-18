package com.example.classapps.MessageApp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.HelloApp.HelloActivity
import com.example.classapps.R

class MessageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        var btnSend = findViewById<Button>(R.id.buttonSend)
        var userText = findViewById<EditText>(R.id.etName)
        btnSend.setOnClickListener{
            Log.i( "btnSend",  "Sending")
            var name = userText.text.toString()
            if(name.isNotEmpty()){
                var textIntent = Intent(this, HelloActivity::class.java)
                textIntent.putExtra("extra_name", name)

                startActivity(textIntent)
            }
        }

        }
    }