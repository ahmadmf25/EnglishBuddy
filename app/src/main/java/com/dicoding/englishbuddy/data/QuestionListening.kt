package com.dicoding.englishbuddy.data

data class QuestionListening (
    val id : Int,
    val question : String,
    val audio: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)