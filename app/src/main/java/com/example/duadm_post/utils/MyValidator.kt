package com.example.duadm_post.utils

import java.util.regex.Pattern
import javax.inject.Inject

class MyValidator @Inject constructor(){

    private val emailPattern: Pattern = Pattern.compile(
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    )


    fun isValidEmail(value: String): Boolean {
        val trimmedValue = value.trim()

        return emailPattern.matcher(trimmedValue).matches()
    }

    fun isValidPassword(value: String): Boolean {
        val trimmedValue = value.length

        return trimmedValue in 8..15
    }

}