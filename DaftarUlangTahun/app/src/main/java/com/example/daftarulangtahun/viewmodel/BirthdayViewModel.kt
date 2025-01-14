package com.example.daftarulangtahun.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daftarulangtahun.data.BirthdayRepository
import com.example.daftarulangtahun.model.Birthday
import kotlinx.coroutines.launch

class BirthdayViewModel(private val repository: BirthdayRepository) : ViewModel() {
    val allBirthdays: LiveData<List<Birthday>> = repository.allBirthdays

    fun insert(birthday: Birthday) {
        viewModelScope.launch {
            repository.insert(birthday)
        }
    }

    fun update(birthday: Birthday) {
        viewModelScope.launch {
            repository.update(birthday)
        }
    }

    fun delete(birthday: Birthday) {
        viewModelScope.launch {
            repository.delete(birthday)
        }
    }
}
