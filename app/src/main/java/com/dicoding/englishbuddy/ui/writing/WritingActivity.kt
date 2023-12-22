package com.dicoding.englishbuddy.ui.writing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.englishbuddy.R
import com.dicoding.englishbuddy.databinding.ActivityWritingBinding
import com.dicoding.englishbuddy.ui.bottom_nav.ui.home.HomeFragment
import com.dicoding.englishbuddy.ui.login.Login

class WritingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWritingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAction()

        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.apply {
            btnSubmit.setOnClickListener {
                val intent = Intent(this@WritingActivity, HomeFragment::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}