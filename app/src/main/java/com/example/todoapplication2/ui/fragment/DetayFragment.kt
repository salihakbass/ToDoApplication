package com.example.todoapplication2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapplication2.R
import com.example.todoapplication2.databinding.FragmentDetayBinding
import com.example.todoapplication2.ui.viewmodel.AnasayfaViewModel
import com.example.todoapplication2.ui.viewmodel.DetayViewModel
import com.example.todoapplication2.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)

        binding.detayFragment = this

        val bundle : DetayFragmentArgs by navArgs()
        val gelenNot = bundle.not
        binding.notNesnesi = gelenNot

        binding.etDetayBaslik.setText(gelenNot.baslik)
        binding.etDetayAciklama.setText(gelenNot.aciklama)

        binding.detayToolbarBaslik= gelenNot.baslik

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(not_id: Int, baslik: String, aciklama: String) {
        viewModel.guncelle(not_id, baslik, aciklama)
    }

}