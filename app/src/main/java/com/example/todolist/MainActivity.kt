package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editButton = findViewById<Button>(R.id.buttonNewItem);
        editButton.setOnClickListener {
            OpenEditPage();
        }
    }

    fun OpenEditPage() {
        val intent = Intent(this, editPage::class.java);
        startActivity(intent);
    }
}