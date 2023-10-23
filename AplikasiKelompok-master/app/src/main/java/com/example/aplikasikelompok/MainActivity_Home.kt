package com.example.aplikasikelompok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasikelompok.databinding.ActivityMainHomeBinding

class MainActivity_Home : AppCompatActivity() {

    private lateinit var binding: ActivityMainHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}