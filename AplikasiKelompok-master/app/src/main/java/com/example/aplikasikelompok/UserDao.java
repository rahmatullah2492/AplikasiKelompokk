package com.example.aplikasikelompok;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

// Ini adalah antarmuka (interface) UserDao yang digunakan untuk mendefinisikan operasi-operasi basis data terkait pengguna.
@Dao
public interface UserDao {

    // Metode ini digunakan untuk memasukkan entitas pengguna ke dalam basis data saat proses pendaftaran.
    @Insert
    void registerUser(UserEntity userEntity);

    // Metode ini digunakan untuk melakukan pencarian pengguna berdasarkan nama pengguna (userId) dan kata sandi (password)
    // saat proses login dan autentikasi.
    @Query("SELECT * from user where usernameApp = :userId and password = :password")
    UserEntity login(String userId, String password);

    // Metode ini digunakan untuk mencari pengguna berdasarkan nama pengguna (username).
    @Query("SELECT * from user where usernameApp = :username")
    UserEntity getUserByUsername(String username);
}
