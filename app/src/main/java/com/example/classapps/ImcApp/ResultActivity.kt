package com.example.classapps.ImcApp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classapps.R
import org.w3c.dom.Text
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        var result: Double= intent.extras?.getDouble("extra_result")?:-1.0
        initComponents()
        initListener()
        initUI(result)



    }
    private fun initComponents(){
        tvResult=findViewById(R.id.tvResult)
        tvIMC=findViewById(R.id.tvIMC)
        tvDescription=findViewById(R.id.tvDescription)
        btnCalculate=findViewById(R.id.btnCalculate)

    }
    private fun initListener(){
        btnCalculate.setOnClickListener{

        }
    }


    private fun initUI(result: Double){
        tvIMC.text=result.toString()
        when (result){
        in 0.00 .. 18.50->{
            tvResult.text = getString(R.string.title_bajo_peso)
            tvResult.setTextColor(getColor(R.color.peso_bajo))
            tvDescription.text = getString(R.string.description_bajo_peso)
        }
            in 18.51..24.99 -> { //Peso normal
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(getColor(R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> { //Sobrepeso
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(getColor(R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00 -> { //Obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> { //Error
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.error)
            }


        }
    }
}