package com.example.duadm_post.data

import com.example.duadm_post.model.PostDataResponse
import okhttp3.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPostData(): List<PostDataResponse>

}