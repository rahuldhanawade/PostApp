package com.example.duadm_post.repository

import androidx.lifecycle.LiveData
import com.example.duadm_post.data.ApiService
import com.example.duadm_post.dbhelper.PostDao
import com.example.duadm_post.model.PostDataResponse
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService, private val postDao: PostDao) {

    suspend fun getPostData(): List<PostDataResponse> {
        return apiService.getPostData()
    }

    suspend fun savePostDataDBList(post: List<PostDataResponse>) {
        postDao.savePostDataDBList(post)
    }

    suspend fun getPostCount(): Int {
        return postDao.getPostCount()
    }

    fun getPostDataDBList(): LiveData<List<PostDataResponse>> {
        return postDao.getPostDataDBList()
    }

    fun getFavoritePosts(): LiveData<List<PostDataResponse>> {
        return postDao.getFavoritePosts()
    }

    suspend fun addToFavorites(post: PostDataResponse) {
        post.id?.let { postDao.addToFavorites(it) }
    }

    suspend fun removeFromFavorites(post: PostDataResponse) {
        post.id?.let { postDao.removeFromFavorites(it) }
    }
}