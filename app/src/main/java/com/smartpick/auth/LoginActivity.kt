package com.smartpick.auth

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartpick.MainActivity
import com.smartpick.databinding.ActivityLoginBinding
import com.smartpick.db.UserDatabaseHelper
import com.smartpick.model.UserModel
import com.smartpick.R

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dbHelper: UserDatabaseHelper
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        // Tombol Login
        binding.btnLogin.setOnClickListener {
            val emailInput = binding.edtEmail.text.toString().trim()
            val passwordInput = binding.edtPassword.text.toString().trim()

            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user: UserModel? = dbHelper.getUserByEmailAndPassword(emailInput, passwordInput)

            if (user != null) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                // Pindah ke Dashboard Fragment dalam MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user_id", user.id)
                intent.putExtra("navigate_to", R.id.navigation_dashboard)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol "Lupa Password"
        binding.btnLupaPassword.setOnClickListener {
            val intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent)
        }

        // Tombol "Belum punya akun? Daftar"
        binding.btnHalamanRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
