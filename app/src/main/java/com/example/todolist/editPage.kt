package com.example.todolist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import java.util.Date
import com.google.gson.Gson

class editPage : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_page)

        val sharedPreferences : SharedPreferences = getSharedPreferences("TODOLIST", Context.MODE_PRIVATE);

        viewModel = ViewModelProvider(this, ItemViewModelFactory(sharedPreferences)).get(ItemViewModel::class.java);

        val saveBtn = findViewById<Button>(R.id.buttonSaveItem);
        saveBtn.setOnClickListener {

            val inputSubject = findViewById<EditText>(R.id.inputSubject).text.toString();
            val inputDescription = findViewById<EditText>(R.id.inputDescription).text.toString();
            //val inputDate = findViewById<EditText>(R.id.inputDate).text.toString();

            viewModel.SaveData(inputSubject, inputDescription);

            OpenMainPage();
        }
    }

    fun OpenMainPage() {
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
    }
}