package com.example.duadm_post.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.duadm_post.R
import com.example.duadm_post.databinding.ActivitySplashBinding
import com.example.duadm_post.ui.home.HomeActivity
import com.example.duadm_post.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this

        lifecycleScope.launch {
            delay(3000)
            if(viewModel.checkUserStatus()){
                startActivity(Intent(this@SplashActivity,HomeActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
                finish()
            }
        }

    }
}