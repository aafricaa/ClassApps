package com.example.classapps.MessageApp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.HelloApp.HelloActivity
import com.example.classapps.R

class RecivedActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recived)

        var btnSend = findViewById<Button>(R.id.buttonSend)
        var userText = findViewById<EditText>(R.id.etName)

        var textoHola = findViewById<TextView>(R.id.helloText)
        var nombre = intent.extras?.getString("extra_name").orEmpty()
        textoHola.text = "Hola $nombre"

        btnSend.setOnClickListener{
            Log.i( "btnSend",  "Sending")
            var name = userText.text.toString()
            if(name.isNotEmpty()){
                var textIntent = Intent(this, HelloActivity::class.java)
                textIntent.putExtra("textMessage", name)

                startActivity(textIntent)
            }
        }
        }
    }