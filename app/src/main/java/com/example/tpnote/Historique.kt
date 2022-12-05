package com.example.tpnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpnote.adapter.HistoriqueAdapteur
import com.example.tpnote.databinding.HistoriqueBinding

class Historique : AppCompatActivity() {
    private lateinit var binding: HistoriqueBinding
    private val historiqueList : ArrayList<Match> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historique)

        binding = HistoriqueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        var personne = bundle?.get("Personne")

        //numberListe.add(personne as Liste)

        val recyclerView : RecyclerView = binding.recyclerView
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@Historique)
            adapter = HistoriqueAdapteur(historiqueList, context)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
        recyclerView.callOnClick()

    }
}