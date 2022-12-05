package com.example.tpnote

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tpnote.databinding.ActivityMainBinding
import com.example.tpnote.model.Joueur


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //layout = binding.mainLayout
        setContentView(view)

        /*
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        database.queryExecutor.execute {
            val allJoueurs: List<Joueur> = database.joueurDao()!!.all
        }*/

        binding.buttonMatch.setOnClickListener() {
            intent = Intent(this, SecondScreen::class.java)
            startActivity(intent)
        }

        binding.buttonHistorique.setOnClickListener() {
            intent = Intent(this, Historique::class.java)
            startActivity(intent)
        }
    }
}