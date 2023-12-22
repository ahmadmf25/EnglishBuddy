package com.dicoding.englishbuddy.ui.register

import androidx.lifecycle.ViewModel
import com.dicoding.englishbuddy.data.UserRepository

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun login(email: String, password: String) =
        userRepository.loginUser(email, password)
}