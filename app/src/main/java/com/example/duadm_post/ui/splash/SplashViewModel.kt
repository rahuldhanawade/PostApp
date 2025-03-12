package com.example.duadm_post.ui.splash

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.duadm_post.repository.MainRepository
import com.example.duadm_post.utils.SharedPreferencesHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferencesHelper
) : ViewModel() {


    fun checkUserStatus() : Boolean {

     return sharedPreferences.getBoolean("is_logged_in")

    }

}
