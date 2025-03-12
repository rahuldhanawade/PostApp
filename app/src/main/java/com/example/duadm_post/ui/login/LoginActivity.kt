package com.example.duadm_post.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.duadm_post.R
import com.example.duadm_post.databinding.ActivityMainBinding
import com.example.duadm_post.ui.home.HomeActivity
import com.example.duadm_post.utils.MyValidator
import com.example.duadm_post.utils.SharedPreferencesHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    private lateinit var dataBinding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels()
    private val validator = MyValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this

        dataBinding.btnLogin.isEnabled = false

        viewModel.editTextEmail.observe(this, Observer { text ->
            if (dataBinding.edtEmail.text.toString() != text) {
                dataBinding.edtEmail.setText(text)
            }
        })

        dataBinding.edtEmail.addTextChangedListener { editable ->
            val newText = editable.toString()
            if (viewModel.editTextEmail.value != newText) {
                viewModel.setEditTextEmailData(newText)
            }
            updateSubmitButtonState()
        }

        viewModel.editTextPassword.observe(this, Observer { text ->
            if (dataBinding.edtPassword.text.toString() != text) {
                dataBinding.edtPassword.setText(text)
            }
        })

        dataBinding.edtPassword.addTextChangedListener { editable ->
            val newText = editable.toString()
            if (viewModel.editTextPassword.value != newText) {
                viewModel.setEditTextPassData(newText)
            }
            updateSubmitButtonState()
        }

        dataBinding.btnLogin.setOnClickListener(View.OnClickListener {
//            val email = dataBinding.edtEmail.text.toString()
//            val pass = dataBinding.edtPassword.text.toString()
//            Log.d("LoginActivity", "Email: $email")
//            Log.d("LoginActivity", "Email: $pass")

            if (viewModel.validateFields()) {
                sharedPreferencesHelper.saveBoolean("is_logged_in", true)
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Log.d("LoginActivity", "Validation Failed")
            }
        })

    }

    private fun updateSubmitButtonState() {
        val email = dataBinding.edtEmail.text.toString()
        val password = dataBinding.edtPassword.text.toString()

        val isEmailValid = validator.isValidEmail(email)
        val isPasswordValid = validator.isValidPassword(password)

        dataBinding.btnLogin.isEnabled = isEmailValid && isPasswordValid
    }

}