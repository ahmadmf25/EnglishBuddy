package com.dicoding.englishbuddy.di

import android.content.Context
import com.dicoding.englishbuddy.data.UserRepository
import com.dicoding.englishbuddy.data.pref.UserPreference
import com.dicoding.englishbuddy.data.pref.datastore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.datastore)
        return UserRepository.getInstance(pref)
    }
}