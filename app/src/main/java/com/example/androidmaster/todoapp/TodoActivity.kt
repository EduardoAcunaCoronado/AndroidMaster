package com.example.androidmaster.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R
import com.example.androidmaster.sintaxis.mutableList
import com.example.androidmaster.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf<Task>(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategories : RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)

        initComponents()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvTasks = findViewById<RecyclerView>(R.id.rvTasks)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }
}