package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.todo.models.Task
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NewBtn = findViewById<Button>(R.id.button)
        NewBtn.setOnClickListener{
            Intent(this,AddTask::class.java).also {
                startActivity(it)
            }
        }
       
    }
}