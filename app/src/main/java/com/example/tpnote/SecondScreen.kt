package com.example.tpnote

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.tpnote.databinding.ActivitySecondScreenBinding


class SecondScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        val view = binding.root
        //layout = binding.mainLayout
        setContentView(view)

        binding.nbSet.setSelection(0)
        val joueur1 = binding.joueur1.text.toString()
        val joueur2 = binding.joueur2.text.toString()
        val nbSet = binding.nbSet.selectedItem.toString().toInt()

        //val match = Match(0,joueur1, joueur2, nbSet, null)

        binding.buttonValider.setOnClickListener {
            intent = Intent(this, ThirdActivity::class.java)
            //intent.putExtra("match", Match as java.io.Serializable)
            intent.putExtra("joueur1", binding.joueur1.text.toString())
            intent.putExtra("joueur2", binding.joueur2.text.toString())
            intent.putExtra("nbSet", binding.nbSet.selectedItem.toString().toInt())
            startActivity(intent)
        }
    }
}