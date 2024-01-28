package com.example.todoapplication2.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.todoapplication2.data.repository.NotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var nrepo : NotRepository)  : ViewModel() {


    fun kaydet(baslik: String, aciklama: String) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.kaydet(baslik, aciklama)
        }

    }
}