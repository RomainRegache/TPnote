package com.example.tpnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tpnote.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //layout = binding.mainLayout
        setContentView(view)
    }
}