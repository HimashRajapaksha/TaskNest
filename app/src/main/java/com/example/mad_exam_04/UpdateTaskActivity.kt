package com.example.mad_exam_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mad_exam_04.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db : TasksDatabaseHelper
    private var taskId : Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        taskId = intent.getIntExtra("task_id",-1)
        if(taskId == -1){
            finish()
            return

        }

        val task = db.getTaskByID(taskId)
        binding.updateTitleEditText.setText(task.title)
        binding.updateTaskContentEditText.setText(task.content)

        binding.updateSaveButton.setOnClickListener {
            val newTitle = binding.updateTitleEditText.text.toString()
            val newContent = binding.updateTaskContentEditText.text.toString()
            val updateTask = Task(taskId,newTitle,newContent)
            db.updateTask(updateTask)
            finish()
            Toast.makeText(this,"Task Updated",Toast.LENGTH_SHORT).show()
        }

    }

}