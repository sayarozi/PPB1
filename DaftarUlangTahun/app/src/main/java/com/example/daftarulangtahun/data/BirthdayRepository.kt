package com.example.daftarulangtahun.data
import androidx.lifecycle.LiveData
import com.example.daftarulangtahun.model.Birthday

class BirthdayRepository(private val birthdayDao: BirthdayDao) {
    val allBirthdays: LiveData<List<Birthday>> = birthdayDao.getAllBirthdays()

    suspend fun insert(birthday: Birthday) {
        birthdayDao.insert(birthday)
    }

    suspend fun update(birthday: Birthday) {
        birthdayDao.update(birthday)
    }

    suspend fun delete(birthday: Birthday) {
        birthdayDao.delete(birthday)
    }
}
