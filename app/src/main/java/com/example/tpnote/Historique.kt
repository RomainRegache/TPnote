package com.example.tpnote

import androidx.appcompat.app.AppCompatActivity
import com.example.tpnote.databinding.HistoriqueBinding
import com.example.tpnote.model.Match

class Historique : AppCompatActivity() {
    private lateinit var binding: HistoriqueBinding
    private val HistoriqueList : ArrayList<Match> = ArrayList()
}