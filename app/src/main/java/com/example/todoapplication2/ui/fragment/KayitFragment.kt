package com.example.todoapplication2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapplication2.R
import com.example.todoapplication2.databinding.FragmentKayitBinding
import com.example.todoapplication2.ui.viewmodel.AnasayfaViewModel
import com.example.todoapplication2.ui.viewmodel.KayitViewModel
import com.example.todoapplication2.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment() : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit, container, false)

        binding.kayifFragment = this
        binding.kayitToolbarBaslik = "Kaydet"
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(baslik: String, aciklama: String) {
        viewModel.kaydet(baslik, aciklama)

    }

}