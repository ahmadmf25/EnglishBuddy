package com.dicoding.englishbuddy.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.englishbuddy.R
import com.dicoding.englishbuddy.databinding.ActivityRegisterBinding
import com.dicoding.englishbuddy.ui.login.Login
import com.dicoding.englishbuddy.utils.ValidateType
import com.dicoding.englishbuddy.utils.validate

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.apply {
            btnGotoLogin.setOnClickListener {
                val intent = Intent(this@Register, Login::class.java)
                startActivity(intent)
                finish()
            }

            btnRegister.setOnClickListener {
                if (validateForm()) {
                    val name = edRegisterName.text.toString()
                    val email = edRegisterEmail.text.toString()
                    val password = edRegisterPassword.text.toString()
                }
            }
        }
    }

    private fun validateForm(): Boolean {
        binding.apply {
            val validates = listOf(
                edRegisterName.validate("Name", ValidateType.REQUIRED),
                edRegisterEmail.validate("Email", ValidateType.REQUIRED),
                edRegisterEmail.validate("Email", ValidateType.EMAIL),
                edRegisterPassword.validate("Password", ValidateType.REQUIRED),
                edRegisterPassword.validate("Password", ValidateType.MIN_CHAR, 8),
            )

            return !validates.contains(false)
        }
    }
}