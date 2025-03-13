package com.example.duadm_post.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duadm_post.di.NetworkHelper
import com.example.duadm_post.model.PostDataResponse
import com.example.duadm_post.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    val posts: LiveData<List<PostDataResponse>> = mainRepository.getPostDataDBList()
    val favorites: LiveData<List<PostDataResponse>> = mainRepository.getFavoritePosts()


    fun loadPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val count = getCount()
            if (networkHelper.isNetworkAvailable() && count == 0) {
                val postsData = mainRepository.getPostData()
                savePostDB(postsData)
            } else {
                getPostDataDBList()
            }
        }
    }

    suspend fun getCount(): Int {
        return withContext(Dispatchers.IO) {
            mainRepository.getPostCount()  // Perform the count fetch operation
        }
    }

    private fun savePostDB(posts: List<PostDataResponse>) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.savePostDataDBList(posts)
        }
    }

    private fun getPostDataDBList() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun toggleFavorite(post: PostDataResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            if (post.isFavorites) {
                mainRepository.removeFromFavorites(post)
            } else {
                mainRepository.addToFavorites(post)
            }
        }
    }

    fun removeFromFavorites(post: PostDataResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.removeFromFavorites(post)
        }
    }

}
