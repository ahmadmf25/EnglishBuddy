package com.dicoding.englishbuddy.data

data class LoginResponse(
    val error: Boolean,
    val message: String,
    val loginResult: LoginResult,
)

data class LoginResult(
    val name: String,
    val userId: String,
    val token: String
)