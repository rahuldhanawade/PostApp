package com.example.duadm_post.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.duadm_post.R
import com.example.duadm_post.databinding.ActivityHomeBinding
import com.example.duadm_post.databinding.ActivityMainBinding
import com.example.duadm_post.ui.splash.SplashActivity
import com.example.duadm_post.utils.SharedPreferencesHelper
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var dataBinding: ActivityHomeBinding
    private val viewModel: PostViewModel by viewModels()
    private lateinit var pagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this

        dataBinding.btnLogout.setOnClickListener(View.OnClickListener {
            sharedPreferencesHelper.clear()
            startActivity(Intent(this,SplashActivity::class.java))
            finish()
        })
        pagerAdapter = ViewPagerAdapter(this)
        dataBinding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(dataBinding.tabLayout, dataBinding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Posts"
                1 -> tab.text = "Favorites"
            }
        }.attach()
    }
}