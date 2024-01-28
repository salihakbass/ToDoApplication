package com.example.todoapplication2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication2.data.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getNotDao() : NotDao
}