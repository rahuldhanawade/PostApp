package com.example.duadm_post.dbhelper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.duadm_post.model.PostDataResponse

@Dao
interface PostDao {

    @Query("select count( * ) from favorite_posts")
    suspend fun getPostCount() : Int

    @Query("UPDATE favorite_posts SET isFavorites = 1 WHERE id = :postId")
    suspend fun addToFavorites(postId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePostDataDBList(posts: List<PostDataResponse>)

    @Query("UPDATE favorite_posts SET isFavorites = 0 WHERE id = :postId")
    suspend fun removeFromFavorites(postId: Int)

    @Query("SELECT * FROM favorite_posts WHERE isFavorites = 1")
    fun getFavoritePosts(): LiveData<List<PostDataResponse>>

    @Query("SELECT * FROM favorite_posts")
    fun getPostDataDBList(): LiveData<List<PostDataResponse>>
}
