package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.todo.models.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = Firebase.database
        val reference = database.getReference("Tasks")
        val text = findViewById<TextView>(R.id.textView3)

        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder()
                for (i in snapshot.children){
                    var taskName = i.child("name").getValue()
                    sb.append("$taskName \n")
                }
                text.text = sb
            }

            override fun onCancelled(error: DatabaseError) {
               Toast.makeText(this@MainActivity,"Failed to read values!",Toast.LENGTH_SHORT).show()
            }
        })



        val NewBtn = findViewById<Button>(R.id.button)
        NewBtn.setOnClickListener{
            Intent(this,AddTask::class.java).also {
                startActivity(it)

            }
        }
       
    }
}

