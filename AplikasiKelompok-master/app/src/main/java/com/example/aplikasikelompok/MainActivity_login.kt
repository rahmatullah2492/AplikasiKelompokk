package com.example.aplikasikelompok

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasikelompok.databinding.ActivityLoginBinding
import java.net.InterfaceAddress

// Kelas ini adalah turunan dari kelas AppCompatActivity
class MainActivity_login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide() // Sembunyikan ActionBar

        // Inisialisasi elemen UI seperti EditText dan Button
        usernameEditText = findViewById(R.id.editTextTextUsername)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.button_login)

        // Menambahkan event listener ke loginButton
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Memvalidasi masukan pengguna
            if (validateInput(username, password)) {
                // Jalankan AsyncTask untuk melakukan operasi database di latar belakang
                LoginAsyncTask().execute(username, password)
            } else {
                Toast.makeText(applicationContext, "Isi kedua kolom!", Toast.LENGTH_SHORT).show()
            }
        }

        // Menambahkan event listener ke teks yang mengarah ke aktivitas pendaftaran
        binding.textBottomDaftar.setOnClickListener {
            val intent = Intent(this, activity_register::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk memvalidasi masukan pengguna
    private fun validateInput(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }

    // Definisikan AsyncTask untuk operasi login di latar belakang
    private inner class LoginAsyncTask : AsyncTask<String, Void, Boolean>() {
        override fun doInBackground(vararg params: String?): Boolean {
            val username = params[0]
            val password = params[1]

            val userDao = UserDatabase.getUserDatabase(this@MainActivity_login).userDao()
            val user = userDao.login(username, password)
            return user != null
        }

        override fun onPostExecute(result: Boolean) {
            if (result) {
                // Jika login berhasil, pindah ke aktivitas utama (MainActivity)
                val intent = Intent(this@MainActivity_login, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika login gagal, tampilkan pesan kesalahan
                Toast.makeText(
                    applicationContext,
                    "Username atau Password Salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
