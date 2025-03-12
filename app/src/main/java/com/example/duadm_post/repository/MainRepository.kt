package com.example.duadm_post.repository

import com.example.duadm_post.data.ApiService
import com.example.duadm_post.model.PostDataResponse
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPostData()  : List<PostDataResponse>{
      return  apiService.getPostData()
    }

}