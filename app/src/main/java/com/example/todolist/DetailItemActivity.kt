package com.example.todolist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DetailItemActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)

        val id: Int = intent.getIntExtra("ID", 0);

        val sharedPreferences : SharedPreferences = getSharedPreferences("TODOLIST", Context.MODE_PRIVATE);

        viewModel = ViewModelProvider(this, ItemViewModelFactory(sharedPreferences)).get(ItemViewModel::class.java);

        val item: Item? = viewModel.LoadItem(id.toString());

        val subjectText = findViewById<TextView>(R.id.detailSubjectInput).apply {
            text = item?.Subject;
        };
        val descriptionText = findViewById<TextView>(R.id.detailDescriptionInput).apply {
            text = item?.Description;
        };

        val menuBtn = findViewById<Button>(R.id.buttonGoToMenu);
        menuBtn.setOnClickListener {
            OpenMainPage();
        }
    }

    fun OpenMainPage() {
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
    }
}