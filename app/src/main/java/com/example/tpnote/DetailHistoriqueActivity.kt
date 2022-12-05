package com.example.tpnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tpnote.databinding.ActivityDetailHistoriqueBinding
import com.example.tpnote.model.Match

class DetailHistoriqueActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHistoriqueBinding
    private val matchListe : ArrayList<Match> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_historique)
        binding = ActivityDetailHistoriqueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        var match = bundle?.get("match_historique")

        //matchListe.add(match as Match)

        /*binding.joueur1.text = matchListe[0].joueur1
        binding.joueur2.text = matchListe[0].joueur2
        binding.nbSet.text = matchListe[0].nbSet.toString()*/

        binding.joueur1.text = bundle?.get("joueur1").toString()
        binding.joueur2.text = bundle?.get("joueur2").toString()
        binding.nbSet.text = bundle?.get("nbSet").toString()
    }
}