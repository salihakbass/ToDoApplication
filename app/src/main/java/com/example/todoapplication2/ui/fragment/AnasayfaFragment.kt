package com.example.todoapplication2.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication2.R
import com.example.todoapplication2.data.ToDos
import com.example.todoapplication2.databinding.FragmentAnasayfaBinding
import com.example.todoapplication2.ui.adapter.NotAdapter
import com.example.todoapplication2.ui.viewmodel.AnasayfaViewModel
import com.example.todoapplication2.ui.viewmodel.KayitViewModel
import com.example.todoapplication2.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding : FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anasayfaFragment = this

       viewModel.notListesi.observe(viewLifecycleOwner) {
           val notAdapter = NotAdapter(requireContext(),it,viewModel)
           binding.notAdapter = notAdapter
       }

        binding.anasayfaToolbarBaslik = "Anasayfa"


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })

        return binding.root


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it : View) {
        Navigation.gecisYap(it,R.id.kayitGecis)
    }

    override fun onResume() {
        super.onResume()
        viewModel.notYukle()
    }


}