package com.example.aplikasikelompok

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import com.example.aplikasikelompok.databinding.ActivitySplashScrennMainBinding

class SplashScrenn_MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScrennMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScrennMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide() // Menyembunyikan actionBar

        // Tampil di awal saat aplikasi di buka dalam
        Handler().postDelayed({

            // ini pindah ke MainActivity_login
            startActivity(Intent(this, MainActivity_login::class.java))
            finish()
        }, 3000) // delay waktunya 3 detik
    }
}