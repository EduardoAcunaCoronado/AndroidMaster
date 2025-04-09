package com.example.androidmaster.imccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 25
    private var currentHeight: Int = 120

    private lateinit var viewMale : CardView
    private lateinit var viewFemale : CardView

    private lateinit var tvHeight : TextView
    private lateinit var rsHeight : RangeSlider

    private lateinit var tvWeight : TextView
    private lateinit var btnPlusWeight : FloatingActionButton
    private lateinit var btnSubtractWeight : FloatingActionButton

    private lateinit var tvAge : TextView
    private lateinit var btnPlusAge : FloatingActionButton
    private lateinit var btnSubtractAge : FloatingActionButton

    private lateinit var btnCalculate : MaterialButton

    companion object {
        const val IMC_RESULT = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)

        initComponent()
        initListeners()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponent() {
        viewMale = findViewById<CardView>(R.id.viewMale)
        viewFemale = findViewById<CardView>(R.id.viewFemale)

        tvHeight = findViewById<TextView>(R.id.tvHeight)
        rsHeight = findViewById<RangeSlider>(R.id.rsHeight)

        tvWeight = findViewById<TextView>(R.id.tvWeight)
        btnPlusWeight = findViewById<FloatingActionButton>(R.id.btnPlusWeight)
        btnSubtractWeight = findViewById<FloatingActionButton>(R.id.btnSubtractWeight)

        tvAge = findViewById<TextView>(R.id.tvAge)
        btnPlusAge = findViewById<FloatingActionButton>(R.id.btnPlusAge)
        btnSubtractAge = findViewById<FloatingActionButton>(R.id.btnSubtractAge)

        btnCalculate = findViewById<MaterialButton>(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender(true)
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender(false)
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"

        }
        btnPlusWeight.setOnClickListener {
            currentWeight++
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight--
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge++
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge--
            setAge()
        }
        btnCalculate.setOnClickListener {
            calculateIMC()
            navigateToResult(calculateIMC());
        }
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender(isMale : Boolean) {
        if(isMale) {
            isMaleSelected = true
            isFemaleSelected = false
        }
        else {
            isMaleSelected = false
            isFemaleSelected = true
        }
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference =
            if(isSelectedComponent)
                R.color.background_component_selected
            else
                R.color.background_component
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun calculateIMC() : Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100*currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_RESULT, result)
        startActivity(intent)
    }
}


