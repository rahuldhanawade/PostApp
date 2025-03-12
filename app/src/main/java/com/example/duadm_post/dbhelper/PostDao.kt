package com.example.duadm_post.dbhelper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

//    @Insert
//    suspend fun insertPosts(posts: List<PostEntity>)

//    @Query("SELECT * FROM favorite_posts")
//    suspend fun getAllPosts(): List<PostEntity>
}
