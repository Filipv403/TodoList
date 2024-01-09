package com.example.todolist

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.util.Date

class ItemViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    //private val _itemsJson = MutableLiveData<List<String>>()
    //val itemsJson: LiveData<List<String>> get() = _itemsJson
    fun SaveData(inputSubject: String, inputDescription: String) {

        val item: Item = Item(inputSubject, inputDescription, Date());
        val jsonString = ItemToJson(item);

        val count = sharedPreferences.all.keys.size;
        val editor = sharedPreferences.edit()
        editor.putString((count + 1).toString(), jsonString)
        editor.apply()
    }

    /*fun GetData() {
        val stringSet = sharedPreferences.getStringSet("TODOLIST", emptySet())
        val stringList = stringSet?.toList() ?: emptyList()
        _itemsJson.postValue(stringList)
    }*/

    private fun ItemToJson(item: Item): String {
        val gson = Gson();
        return gson.toJson(item);
    }

    private fun JsonToItem(json: String): Item {
        val gson = Gson()
        return gson.fromJson(json, Item::class.java)
    }
}