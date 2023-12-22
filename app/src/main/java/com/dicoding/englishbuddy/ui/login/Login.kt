package com.dicoding.englishbuddy.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.dicoding.englishbuddy.R
import com.dicoding.englishbuddy.data.pref.UserModel
import com.dicoding.englishbuddy.databinding.ActivityLoginBinding
import com.dicoding.englishbuddy.ui.MainActivity
import com.dicoding.englishbuddy.ui.ViewModelFactory
import com.dicoding.englishbuddy.ui.bottom_nav.BottomNavigation
import com.dicoding.englishbuddy.ui.register.Register
import com.dicoding.englishbuddy.utils.ValidateType
import com.dicoding.englishbuddy.utils.validate

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.apply {
            btnGotoRegister.setOnClickListener {
                val intent = Intent(this@Login, Register::class.java)
                startActivity(intent)
                finish()
            }

            btnLogin.setOnClickListener {
                if (validateForm()) {
                    val email = edLoginEmail.text.toString()
                    val password = edLoginPassword.text.toString()

                    viewModel.saveSession(UserModel(email, "sample_token"))
                    AlertDialog.Builder(this@Login).apply {
                        setTitle("Yeah!")
                        setMessage("Anda berhasil login. Sudah tidak sabar untuk belajar ya?")
                        setPositiveButton("Lanjut") { _, _ ->
                            val intent = Intent(context, BottomNavigation   ::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }
                        create()
                        show()
                    }
                }
            }
        }
    }

    private fun validateForm(): Boolean {
        binding.apply {
            val validates = listOf(
                edLoginEmail.validate("Email", ValidateType.REQUIRED),
                edLoginEmail.validate("Email", ValidateType.EMAIL),
                edLoginPassword.validate("Password", ValidateType.REQUIRED),
                edLoginPassword.validate("Password", ValidateType.MIN_CHAR, 8),
            )

            return !validates.contains(false)
        }
    }
}