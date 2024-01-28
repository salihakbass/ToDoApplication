package com.example.todoapplication2.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication2.R
import com.example.todoapplication2.data.ToDos
import com.example.todoapplication2.databinding.CardTasarimBinding
import com.example.todoapplication2.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapplication2.ui.viewmodel.AnasayfaViewModel
import com.example.todoapplication2.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class NotAdapter(var mContext: Context, var notListesi: List<ToDos>,var viewModel: AnasayfaViewModel) :
    RecyclerView.Adapter<NotAdapter.ViewHolder>() {
    inner class ViewHolder(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CardTasarimBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.card_tasarim, parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val not = notListesi.get(position)
        val t = holder.tasarim

        t.notNesnesi = not

        t.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(not)
            Navigation.gecisYap(it,gecis)
        }
        t.imgDelete.setOnClickListener {
            Snackbar.make(it, "${not.baslik} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.sil(not.not_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return notListesi.size
    }

    fun sil(not_id: Int) {
        viewModel.sil(not_id)
    }
}