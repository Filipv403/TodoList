package com.example.todolist

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val sharedPreferences: SharedPreferences) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemSubject : TextView;
        var itemDescription : TextView;

        init {
            itemSubject = itemView.findViewById(R.id.itemSubject);
            itemDescription = itemView.findViewById(R.id.itemDescription);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return sharedPreferences.all.keys.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}