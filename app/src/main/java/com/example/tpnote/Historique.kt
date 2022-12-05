package com.example.tpnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpnote.adapter.HistoriqueAdapteur
import com.example.tpnote.databinding.HistoriqueBinding
import com.example.tpnote.model.Match

class Historique : AppCompatActivity() {
    private lateinit var binding: HistoriqueBinding
    private val historiqueList : ArrayList<Match> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historique)

        binding = HistoriqueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        remplirLesLignes()
        val recyclerView : RecyclerView = binding.recyclerView
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@Historique)
            adapter = HistoriqueAdapteur(historiqueList, context)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
        recyclerView.callOnClick()

    }

    private fun remplirLesLignes() {
        historiqueList.add(
            Match(1, "Nico", "Romain", 3, null)
        )
        historiqueList.add(
            Match(1, "Nico", "Romain", 5, null)
        )
    }
}