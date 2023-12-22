package com.dicoding.englishbuddy.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dicoding.englishbuddy.data.pref.UserModel
import com.dicoding.englishbuddy.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow
import com.dicoding.englishbuddy.utils.Result

class UserRepository private constructor(
    private val userPreference: UserPreference
){
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    suspend fun getSession() =
        userPreference.getSession()


    fun loginUser(email: String, password: String) : LiveData<Result<LoginResponse>> =
        liveData {
            emit(Result.Loading)
            try {
                val fakeResponse = simulateLogin(email, password)

                if (fakeResponse.error) {
                    Log.d("Login Error", fakeResponse.message)
                    emit(Result.Error("Login Error : &{fakeResponse.message}"))
                } else {
                    Log.d("Login Success",fakeResponse.message)
                    emit(Result.Success(fakeResponse))

                    userPreference.saveSession(
                        UserModel(
                            fakeResponse.loginResult.name,
                            fakeResponse.loginResult.token,
                            true
                        )
                    )
                }
            } catch (e: Exception) {
                Log.d("Login Exception", e.message.toString())
                emit(Result.Error("Error: ${e.message.toString()}"))
            }
        }

    suspend fun logout() {
        userPreference.logout()
    }

    private fun simulateLogin(email: String, password: String) : LoginResponse {
        return if (email == "user@example.com" && password == "password") {
            LoginResponse(false,"Login Succes", LoginResult("", "John Cena", "Fake Token"))
        } else {
            LoginResponse(true, "Invalid Crendential", LoginResult("", "", ""))
        }
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference)
            }.also { instance = it }
    }
}