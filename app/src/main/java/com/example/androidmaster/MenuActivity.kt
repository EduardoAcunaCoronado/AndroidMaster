package com.example.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.firstapp.FirstAppActivity
import com.example.androidmaster.imccalculator.ImcCalculatorActivity
import com.example.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)

        btnSaludApp.setOnClickListener { navigateToSaludApp () }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTTodoApp() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navigateToSaludApp () {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    fun navigateToIMCApp () {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    fun navigateToTTodoApp () {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}

