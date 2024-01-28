package com.example.todoapplication2.data.repository

import com.example.todoapplication2.data.ToDos
import com.example.todoapplication2.data.datasource.NotDataSource

class NotRepository(var nds : NotDataSource) {


    suspend fun kaydet(baslik: String, aciklama: String) = nds.kaydet(baslik,aciklama)

    suspend fun guncelle(not_id: Int, baslik: String, aciklama: String) = nds.guncelle(not_id,baslik, aciklama)

    suspend fun sil(not_id: Int) = nds.sil(not_id)

    suspend fun notYukle() : List<ToDos> = nds.notYukle()

    suspend fun ara(aramaKelimesi : String) : List<ToDos> = nds.ara(aramaKelimesi)
}