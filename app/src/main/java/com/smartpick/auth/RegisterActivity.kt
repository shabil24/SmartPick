package com.smartpick.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartpick.databinding.ActivityRegisterBinding
import com.smartpick.db.UserDatabaseHelper
import com.smartpick.model.UserModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        // Tombol "Sudah punya akun? Login"
        binding.btnHalamanLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Tombol Register
        binding.btnRegister.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            val konfirmasiPassword = binding.edtPasswordKonfirmasi.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || konfirmasiPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != konfirmasiPassword) {
                Toast.makeText(this, "Password dan konfirmasi password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = UserModel(
                id = 0,
                username = username,
                email = email,
                password = password
            )

            val result = dbHelper.insertUser(user)

            if (result != -1L) {
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Registrasi gagal! Email mungkin sudah terdaftar.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
