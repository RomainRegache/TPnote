package com.example.tpnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tpnote.databinding.ActivityDetailHistoriqueBinding

class DetailHistoriqueActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHistoriqueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_historique)
        binding = ActivityDetailHistoriqueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}