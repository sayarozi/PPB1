package com.example.test_roompersistence

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_roompersistence.room.Note

class NoteAdapter(private val notes:List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int = notes.size

    class NoteViewHolder(private val view: android.view.View ): RecyclerView.ViewHolder(view) {
        fun bind(note: Note){
            val titleTextView = view.findViewById<TextView>(R.id.textViewTitle)
            val contextTextView = view.findViewById<TextView>(R.id.textViewContent)
            val timestampTextView = view.findViewById<TextView>(R.id.textViewTimestamp)

            titleTextView.text = note.title
            contextTextView.text = note.content
            timestampTextView.text = note.timestamp
        }
    }
}