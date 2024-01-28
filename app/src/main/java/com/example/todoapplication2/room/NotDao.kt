package com.example.todoapplication2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapplication2.data.ToDos

@Dao
interface NotDao {
    @Query("SELECT * FROM todos")
    suspend fun notYukle(): List<ToDos>

    @Insert
    suspend fun kaydet(not: ToDos)

    @Update
    suspend fun guncelle(not: ToDos)

    @Delete
    suspend fun sil(not : ToDos)

    @Query("SELECT * FROM todos WHERE baslik like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi : String) : List<ToDos>
}