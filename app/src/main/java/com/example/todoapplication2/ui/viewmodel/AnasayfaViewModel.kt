package com.example.todoapplication2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication2.data.ToDos
import com.example.todoapplication2.data.repository.NotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var nrepo : NotRepository) : ViewModel() {

    var notListesi = MutableLiveData<List<ToDos>>()

    init {
        notYukle()
    }

    fun sil(not_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.sil(not_id)
            notYukle()
        }
    }

    fun notYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            notListesi.value = nrepo.notYukle()
        }
    }

    fun ara(aramaKelimesi : String){
        CoroutineScope(Dispatchers.Main).launch{
            notListesi.value = nrepo.ara(aramaKelimesi)
        }
    }
}