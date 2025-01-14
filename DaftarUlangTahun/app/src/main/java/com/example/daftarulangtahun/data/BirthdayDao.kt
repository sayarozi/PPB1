package com.example.daftarulangtahun.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.daftarulangtahun.model.Birthday

@Dao
interface BirthdayDao {
    @Insert
    suspend fun insert(birthday: Birthday)

    @Update
    suspend fun update(birthday: Birthday)

    @Delete
    suspend fun delete(birthday: Birthday)

    @Query("SELECT * FROM birthdays ORDER BY date ASC")
    fun getAllBirthdays(): LiveData<List<Birthday>>
}