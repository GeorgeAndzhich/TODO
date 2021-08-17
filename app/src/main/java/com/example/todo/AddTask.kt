package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.todo.models.Task
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*


class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val database = Firebase.database
        val reference = database.getReference("Tasks")

        val TaskName = findViewById<TextView>(R.id.editTextTextPersonName)
        val date = findViewById<TextView>(R.id.editTextDate)
        val addBtn = findViewById<Button>(R.id.button2)

        addBtn.setOnClickListener{
            val task = Task(TaskName.text.toString(),false,date.text.toString())
            reference.child(TaskName.text.toString()).setValue(task).addOnSuccessListener {
                TaskName.clearComposingText()
                date.clearComposingText()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
            } .addOnFailureListener{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}