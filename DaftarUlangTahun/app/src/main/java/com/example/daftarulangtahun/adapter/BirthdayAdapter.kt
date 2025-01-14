package com.example.daftarulangtahun.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarulangtahun.model.Birthday

class BirthdayAdapter(private var birthdays: List<Birthday>, private val onClick: (Birthday) -> Unit) :
    RecyclerView.Adapter<BirthdayAdapter.BirthdayViewHolder>() {

    class BirthdayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(android.R.id.text1)
        val dateTextView: TextView = itemView.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return BirthdayViewHolder(view)
    }

    override fun onBindViewHolder(holder: BirthdayViewHolder, position: Int) {
        val birthday = birthdays[position]
        holder.nameTextView.text = birthday.name
        holder.dateTextView.text = birthday.date
        holder.itemView.setOnClickListener { onClick(birthday) }
    }

    override fun getItemCount(): Int = birthdays.size

}