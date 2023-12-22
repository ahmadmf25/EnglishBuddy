package com.dicoding.englishbuddy.ui.listening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.dicoding.englishbuddy.R
import com.dicoding.englishbuddy.data.Constants
import com.dicoding.englishbuddy.ui.bottom_nav.ui.home.HomeFragment

class ResultListeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_listening)

        supportActionBar?.hide()

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val scoreMessage = getString(R.string.total_score, correctAnswers,totalQuestions)
        tvScore.text = scoreMessage

        btnFinish.setOnClickListener {
            startActivity(Intent(this, HomeFragment::class.java))
        }
    }
}