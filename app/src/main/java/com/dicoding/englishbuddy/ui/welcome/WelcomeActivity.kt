package com.dicoding.englishbuddy.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.englishbuddy.R
import com.dicoding.englishbuddy.databinding.ActivityWelcomeBinding
import com.dicoding.englishbuddy.ui.login.Login
import com.dicoding.englishbuddy.ui.register.Register

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.apply {
            btnGotoLogin.setOnClickListener {
                val intent = Intent(this@WelcomeActivity, Login::class.java)
                startActivity(intent)
            }

            btnGotoRegister.setOnClickListener{
                val intent = Intent(this@WelcomeActivity, Register::class.java)
                startActivity(intent)
            }
        }
    }
}