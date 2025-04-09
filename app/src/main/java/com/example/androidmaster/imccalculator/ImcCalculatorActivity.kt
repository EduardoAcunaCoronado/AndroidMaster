package com.example.androidmaster.imccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale : CardView
    private lateinit var viewFemale : CardView

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
    }

}