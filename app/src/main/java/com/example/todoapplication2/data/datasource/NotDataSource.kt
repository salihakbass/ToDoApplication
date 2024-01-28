package com.example.todoapplication2.data.datasource

import android.util.Log
import com.example.todoapplication2.data.ToDos
import com.example.todoapplication2.room.NotDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotDataSource(var ndao: NotDao) {

    suspend fun notYukle(): List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext ndao.notYukle()
    }

    suspend fun kaydet(baslik: String, aciklama: String) {
        val yeniNot = ToDos(0, baslik, aciklama)
        ndao.kaydet(yeniNot)
    }

    suspend fun guncelle(not_id: Int, baslik: String, aciklama: String) {
        val guncellenenNot = ToDos(not_id, baslik, aciklama)
        ndao.guncelle(guncellenenNot)
    }

    suspend fun sil(not_id: Int) {
        val silinenNot = ToDos(not_id, "", "")
        ndao.sil(silinenNot)
    }

    suspend fun ara(aramaKelimesi: String): List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext ndao.ara(aramaKelimesi)
    }
}