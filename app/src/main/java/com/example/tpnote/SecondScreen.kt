package com.example.tpnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tpnote.databinding.ActivityMainBinding
import com.example.tpnote.databinding.ActivitySecondScreenBinding
import com.example.tpnote.model.Match

class SecondScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        val view = binding.root
        //layout = binding.mainLayout
        setContentView(view)

        val joueur1 = binding.joueur1.text.toString()
        val joueur2 = binding.joueur2.text.toString()
        val nbSet = binding.nbSet

        val match = Match(joueur1, joueur2, nbSet)

        binding.buttonValider.setOnClickListener {
            intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("match", Match as java.io.Serializable)
            startActivity(intent)
        }
    }
}