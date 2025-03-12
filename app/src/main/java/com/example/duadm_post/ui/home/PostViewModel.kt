package com.example.duadm_post.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duadm_post.model.PostDataResponse
import com.example.duadm_post.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _posts = MutableLiveData<List<PostDataResponse>>()
    val posts: LiveData<List<PostDataResponse>> get() = _posts

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(mainRepository.getPostData())
        }
    }

}
