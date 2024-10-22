package com.example.classapps.ImcApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classapps.R
import com.google.android.material.slider.RangeSlider
import java.lang.Math.pow
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class IMCActivity : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstractWeight: CardView
    private lateinit var btnAddWeight: CardView
    private lateinit var btnSubstractAge: CardView
    private lateinit var btnAddAge: CardView
    private lateinit var numEdad: TextView
    private lateinit var btnCalculate: Button

    private var currentWeight: Int = 70
    private var currentEdad: Int = 50
    private var currentHeight: Int = 120


    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponents()
        initListeners()

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.numPeso)
        btnSubstractWeight = findViewById(R.id.pesoSubstract)
        btnAddWeight = findViewById(R.id.pesoAdd)
        btnSubstractAge = findViewById(R.id.edadSubstract)
        btnAddAge = findViewById(R.id.edadAdd)
        numEdad = findViewById(R.id.numEdad)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorMale() }
        viewFemale.setOnClickListener { setComponentColorFemale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubstractWeight.setOnClickListener {
            currentWeight -= 1
            tvWeight.text = currentWeight.toString()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            tvWeight.text = currentWeight.toString()
        }
        btnSubstractAge.setOnClickListener {
            currentEdad -= 1
            numEdad.text = currentEdad.toString()
        }
        btnAddAge.setOnClickListener {
            currentEdad += 1
            numEdad.text = currentEdad.toString()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(r: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("extra_result", r)
        startActivity(intent)

    }

    private fun calculateIMC(): Double {
        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'
        val df = DecimalFormat("#.##")
        df.decimalFormatSymbols=dfs
        val imc = currentWeight / pow(currentHeight.toDouble() / 100, 2.0)

        return df.format(imc).toDouble()
    }


    private fun setComponentColorMale() {
        if (!isMaleSelected) {
            viewMale.setBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setComponentColorFemale() {
        if (!isFemaleSelected) {
            viewFemale.setBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = false
            isFemaleSelected = true
        }
    }
}
