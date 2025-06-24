package com.smartpick.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartpick.databinding.ActivityPasswordBinding
import com.smartpick.db.UserDatabaseHelper

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding
    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        binding.btnSimpan.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val passwordBaru = binding.edtPasswordBaru.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || passwordBaru.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = dbHelper.getUserByEmail(email)
            if (user != null && user.username == username) {
                // Buat user baru dengan password yang diperbarui
                val updatedUser = user.copy(password = passwordBaru)

                val result = dbHelper.updateUser(updatedUser)
                if (result > 0) {
                    Toast.makeText(this, "Password berhasil diperbarui!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Gagal memperbarui password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Username atau email tidak cocok", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
