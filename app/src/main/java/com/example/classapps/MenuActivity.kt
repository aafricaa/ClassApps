package com.example.classapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classapps.HelloApp.MainActivity
import com.example.classapps.ImcApp.IMCActivity
import com.example.classapps.MessageApp.MessageActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnIMACApp = findViewById<Button>(R.id.btnIMCApp)

        btnHelloApp.setOnClickListener { navigateUptoHelloApp() }
        btnMessageApp.setOnClickListener { navigateUpToMessageApp() }
        btnIMACApp.setOnClickListener { navigateUptoIMACApp() }


    }

    private fun navigateUptoHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    private fun navigateUpToMessageApp() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateUptoIMACApp() {
        var intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
}