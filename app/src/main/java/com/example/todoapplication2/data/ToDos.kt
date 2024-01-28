package com.example.todoapplication2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class ToDos(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") @NotNull val not_id: Int,
    @ColumnInfo(name = "baslik") @NotNull val baslik: String,
    @ColumnInfo(name = "aciklama") @NotNull val aciklama: String
) : Serializable {
}