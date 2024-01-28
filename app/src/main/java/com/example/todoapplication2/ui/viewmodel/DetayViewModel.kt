package com.example.todoapplication2.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.todoapplication2.R
import com.example.todoapplication2.data.repository.NotRepository
import com.example.todoapplication2.util.gecisYap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var nrepo : NotRepository)  : ViewModel() {


    fun guncelle(not_id: Int, baslik: String, aciklama: String) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.guncelle(not_id, baslik, aciklama)
        }
    }
}