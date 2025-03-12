package com.example.duadm_post.ui.home.favoritesFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.duadm_post.dbhelper.PostDao
import com.example.duadm_post.dbhelper.PostEntity
import com.example.duadm_post.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: MainRepository, private val postDao: PostDao) : ViewModel() {

//    val favoritesPosts: LiveData<List<PostEntity>> = postDao.getFavoritePosts()

}