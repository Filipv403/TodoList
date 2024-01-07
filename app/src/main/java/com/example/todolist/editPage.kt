package com.example.todolist

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.Date
import com.google.gson.Gson

class editPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_page)

        val saveBtn = findViewById<Button>(R.id.buttonSaveItem);
        saveBtn.setOnClickListener {
            SaveData();
        }
    }

    private fun SaveData() {
        val inputSubject = findViewById<EditText>(R.id.inputSubject).text.toString();
        val inputDate = findViewById<EditText>(R.id.inputDate).text.toString();

        val item: Item = Item(inputSubject, Date());
        val jsonString = ItemToJson(item);

        val sharedPreferences : SharedPreferences = getSharedPreferences("TODOLIST", Context.MODE_PRIVATE);
        val count = sharedPreferences.all.keys.size;
        val editor = sharedPreferences.edit()
        editor.putString((count + 1).toString(), jsonString)
        editor.apply()
    }

    private fun ItemToJson(item: Item): String {
        val gson = Gson();
        return gson.toJson(item);
    }

    private fun JsonToItem(json: String): Item {
        val gson = Gson()
        return gson.fromJson(json, Item::class.java)
    }
}