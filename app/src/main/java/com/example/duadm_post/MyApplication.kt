package com.example.duadm_post

import android.app.Application
import android.util.Log
import com.example.duadm_post.repository.MainRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application()  {

}