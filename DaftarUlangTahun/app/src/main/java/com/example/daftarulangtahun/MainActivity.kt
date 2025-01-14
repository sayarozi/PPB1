package com.example.daftarulangtahun

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.example.daftarulangtahun.adapter.BirthdayAdapter
import com.example.daftarulangtahun.data.BirthdayDatabase
import com.example.daftarulangtahun.data.BirthdayRepository
import com.example.daftarulangtahun.model.Birthday
import com.example.daftarulangtahun.viewmodel.BirthdayViewModel
import com.example.daftarulangtahun.viewmodel.BirthdayViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var birthdayViewModel: BirthdayViewModel
    private lateinit var birthdayAdapter: BirthdayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextDate = findViewById<EditText>(R.id.editTextDate)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        birthdayAdapter = BirthdayAdapter(emptyList()) { birthday ->
            // Handle item click (optional)
        }
        recyclerView.adapter = birthdayAdapter

        // Initialize ViewModel
        val birthdayDao = BirthdayDatabase.getDatabase(application).birthdayDao()
        val repository = BirthdayRepository(birthdayDao)
        val factory = BirthdayViewModelFactory(repository)
        birthdayViewModel = viewModels<BirthdayViewModel> { factory }.value

        // Observe the LiveData
        birthdayViewModel.allBirthdays.observe(this, Observer { birthdays ->
            birthdays?.let {
                birthdayAdapter = BirthdayAdapter(it) { birthday ->
                    // Handle item click (optional)
                }
                recyclerView.adapter = birthdayAdapter
            }
        })

        // Add button click listener
        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val date = editTextDate.text.toString()
            if (name.isNotEmpty() && date.isNotEmpty()) {
                val birthday = Birthday(name = name, date = date)
                birthdayViewModel.insert(birthday)
                editTextName.text.clear()
                editTextDate.text.clear()
            }
        }
    }
}