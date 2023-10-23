package com.example.aplikasikelompok

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasikelompok.databinding.ActivityRegisterBinding


// Ini adalah definisi kelas activity_register yang merupakan turunan dari AppCompatActivity
class activity_register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userId: EditText
    private lateinit var usernameGitHub: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi elemen UI seperti EditText dan Button dengan cari id nya masing-masing
        userId = findViewById(R.id.editTextTextUsernameApp)
        usernameGitHub = findViewById(R.id.editTextTextUsernameGitHub)
        email = findViewById(R.id.editTextTextEmailAddress5)
        password = findViewById(R.id.editTextTextPassword3)
        signUpButton = findViewById(R.id.button_signUp)

        supportActionBar?.hide() // Sembunyikan ActionBar

        // Menambahkan event listener ke signUpButton
        signUpButton.setOnClickListener {
            val usernameApp = userId.text.toString()
            val usernameGit = usernameGitHub.text.toString()
            val userEmail = email.text.toString()
            val pass = password.text.toString()

            // Memvalidasi masukan pengguna
            if (validateInput(usernameApp, usernameGit, userEmail, pass)) {
                val userEntity = UserEntity()
                userEntity.setUsernameApp(usernameApp)
                userEntity.setUsernameGitHub(usernameGit)
                userEntity.setEmail(userEmail)
                userEntity.setPassword(pass)

                val userDatabase = UserDatabase.getUserDatabase(applicationContext)
                val userDao = userDatabase.userDao()

                // Membuat thread terpisah untuk operasi basis data
                Thread {
                    userDao.registerUser(userEntity)
                    runOnUiThread {
                        // muncul ketika pengguna berhasil mendaftar/registrasi
                        Toast.makeText(applicationContext, "User Registered!", Toast.LENGTH_SHORT).show()
                    }
                }.start()

                // Pindah ke aktivitas login setelah pendaftaran berhasil
                val intent = Intent(this, MainActivity_login::class.java)
                startActivity(intent)

            } else {
                // Menampilkan pnotifikasi melengkapi form loginya
                Toast.makeText(applicationContext, "Fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }

        // Menambahkan event listener ke tombol kembali
        binding.backKiriSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity_login::class.java)
            startActivity(intent)
        }

        // Menambahkan event listener ke teks yang mengarah ke aktivitas login
        binding.textBottomLogin.setOnClickListener {
            val intent = Intent(this, MainActivity_login::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk memvalidasi masukan pengguna
    private fun validateInput(usernameApp: String, usernameGitHub: String, email: String, password: String): Boolean {
        return usernameApp.isNotEmpty() && usernameGitHub.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
    }
}