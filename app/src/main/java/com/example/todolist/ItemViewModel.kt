package com.example.todolist

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.util.Date

class ItemViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    fun SaveData(inputSubject: String, inputDescription: String) {

        val item: Item = Item(inputSubject, inputDescription);
        val jsonString = ItemToJson(item);

        val count = sharedPreferences.all.keys.size;
        val editor = sharedPreferences.edit();
        editor.putString((count).toString(), jsonString);
        editor.apply();
    }

    fun LoadItem(id : String) : Item? {
        val jsonString = sharedPreferences.getString(id, null);
        if (jsonString != null) {
            return JsonToItem(jsonString);
        } else {
            return null;
        }
    }

    fun ClearItems() {
        sharedPreferences.edit().clear().apply();
    }

    fun GetCount() : Int {
        return sharedPreferences.all.keys.size;
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