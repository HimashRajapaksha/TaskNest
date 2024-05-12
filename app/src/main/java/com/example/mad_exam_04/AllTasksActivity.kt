package com.example.mad_exam_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mad_exam_04.databinding.ActivityAllTasksBinding
import com.example.mad_exam_04.databinding.ActivityMainBinding


class AllTasksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllTasksBinding
    private lateinit var db: TasksDatabaseHelper
    private lateinit var tasksAdapter: TasksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db =TasksDatabaseHelper(this)
        tasksAdapter = TasksAdapter(db.getAllTasks(),this)

        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter = tasksAdapter


        binding.addButton.setOnClickListener{
            val intent = Intent(this, AddNewTaskActivity::class.java) // Corrected Intent constructor
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        tasksAdapter.refreshData(db.getAllTasks())
    }

}