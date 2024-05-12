package com.example.mad_exam_04


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.example.mad_exam_04.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedButton = findViewById<Button>(R.id.startButton)
        getStartedButton.setOnClickListener {
            val intent = Intent(this, AllTasksActivity::class.java)
            startActivity(intent)
        }
    }
}


