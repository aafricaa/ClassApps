package com.example.classapps.HelloApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.classapps.R

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        var textoHola = findViewById<TextView>(R.id.helloText)

        var nombre = intent.extras?.getString("extra_name").orEmpty()
        textoHola.text = "Hola $nombre"
        }
    }