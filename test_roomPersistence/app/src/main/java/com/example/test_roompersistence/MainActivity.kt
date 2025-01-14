package com.example.test_roompersistence

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_roompersistence.room.MainViewModel
import com.example.test_roompersistence.room.Note
import com.example.test_roompersistence.ui.AddNoteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var mainViewModel: MainViewModel


    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if ( result.resultCode == Activity.RESULT_OK){
            Toast.makeText(this,"note Add Succesfully", Toast.LENGTH_SHORT).show()
            mainViewModel.fetchNotes()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerViewNotes)
        recyclerView.layoutManager = LinearLayoutManager(this)


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.allNotes.observe(this){notes ->
            updateRecyclerView(notes)
        }

        val buttonAddNote: Button = findViewById(R.id.buttonAddNote)
        buttonAddNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startForResult.launch(intent)
        }
    }

    private fun updateRecyclerView(notes: List<Note>){
        if(:: noteAdapter.isInitialized){
            noteAdapter.notifyDataSetChanged()
            noteAdapter = NoteAdapter (notes)
            recyclerView.adapter = noteAdapter
        }else{
            noteAdapter = NoteAdapter(notes)
            recyclerView.adapter = noteAdapter
        }
    }
}