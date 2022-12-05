package com.example.tpnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tpnote.databinding.ActivitySecondScreenBinding
import com.example.tpnote.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonJ1.setOnClickListener() {
            var score_actuel = binding.buttonJ1.text.toString().toInt()
            if (score_actuel<10) {
                binding.buttonJ1.text = (score_actuel+1).toString()
            }
            else {
                binding.buttonJ1.text = (0).toString()
                binding.buttonJ2.text = (0).toString()
            }
        }

        binding.buttonJ2.setOnClickListener() {
            var score_actuel = binding.buttonJ2.text.toString().toInt()
            if (score_actuel<10) {
                binding.buttonJ2.text = (score_actuel+1).toString()
            }
            else {
                binding.buttonJ1.text = (0).toString()
                binding.buttonJ2.text = (0).toString()
            }
        }
    }
}