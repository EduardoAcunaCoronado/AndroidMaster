package com.example.androidmaster.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R
import com.example.androidmaster.imccalculator.ImcCalculatorActivity.Companion.IMC_RESULT
import com.google.android.material.button.MaterialButton

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult : TextView
    private lateinit var tvIMC : TextView
    private lateinit var tvDescription : TextView
    private lateinit var btnRecalculate : MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)

        val result = intent.extras?.getDouble(IMC_RESULT) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents() {
        tvResult = findViewById<TextView>(R.id.tvResult)
        tvIMC = findViewById<TextView>(R.id.tvIMC)
        tvDescription = findViewById<TextView>(R.id.tvDescription)
        btnRecalculate = findViewById<MaterialButton>(R.id.btnRealculate)
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }

            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }

            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }

            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> {
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvIMC.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initListeners () {
        btnRecalculate.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}