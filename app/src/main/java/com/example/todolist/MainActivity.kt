package com.example.todolist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val sharedPreferences : SharedPreferences = getSharedPreferences("TODOLIST", Context.MODE_PRIVATE);

        viewModel = ViewModelProvider(this, ItemViewModelFactory(sharedPreferences)).get(ItemViewModel::class.java);

        val recyclerView = findViewById<RecyclerView>(R.id.itemsView);
        val adapter = ItemAdapter(viewModel);
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val editButton = findViewById<Button>(R.id.buttonNewItem);
        editButton.setOnClickListener {
            OpenEditPage();
        }

        val clearButton = findViewById<Button>(R.id.buttonClear);
        clearButton.setOnClickListener {
            ClearStorage(viewModel, adapter);
        }
    }

    fun OpenEditPage() {
        val intent = Intent(this, editPage::class.java);
        startActivity(intent);
    }

    fun ClearStorage(view : ItemViewModel, adapter: ItemAdapter) {
        view.ClearItems();
        adapter.notifyDataSetChanged();
    }
}