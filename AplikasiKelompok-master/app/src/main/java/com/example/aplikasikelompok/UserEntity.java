package com.example.aplikasikelompok;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Ini adalah definisi entitas (Entity) yang merepresentasikan tabel 'user' dalam basis data Room.
@Entity(tableName = "user")
public class UserEntity {

    // Kolom ID dengan otomatis penambahan nilai (auto-generate) sebagai kunci utama.
    @PrimaryKey(autoGenerate = true)
    Integer id;

    // Kolom 'usernameApp' yang akan menyimpan nama pengguna aplikasi.
    @ColumnInfo(name = "usernameApp")
    String usernameApp;

    // Kolom 'usernameGitHub' yang akan menyimpan nama pengguna GitHub.
    @ColumnInfo(name = "usernameGitHub")
    String usernameGitHub;

    // Kolom 'email' yang akan menyimpan alamat email pengguna.
    @ColumnInfo(name = "email")
    String email;

    // Kolom 'password' yang akan menyimpan kata sandi pengguna.
    @ColumnInfo(name = "password")
    String password;


    // Getter dan setter untuk masing-masing atribut.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernameApp() {
        return usernameApp;
    }

    public void setUsernameApp(String usernameApp) {
        this.usernameApp = usernameApp;
    }

    public String getUsernameGitHub() {
        return usernameGitHub;
    }

    public void setUsernameGitHub(String usernameGitHub) {
        this.usernameGitHub = usernameGitHub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
