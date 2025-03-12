package com.example.duadm_post.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.duadm_post.repository.MainRepository
import com.example.duadm_post.utils.MyValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: MainRepository, private val myValidator: MyValidator) : ViewModel() {

    val editTextEmail = MutableLiveData<String>()
    val editTextPassword = MutableLiveData<String>()

    fun setEditTextEmailData(text: String) {
        editTextEmail.value = text
    }

    fun setEditTextPassData(text: String) {
        editTextPassword.value = text
    }

    fun validateFields() : Boolean{
        var result = true

        if(!myValidator.isValidEmail(editTextEmail.value.toString())){
            result = false
        }

        if(!myValidator.isValidPassword(editTextPassword.value.toString())){
            result = false
        }

        return result
    }

}