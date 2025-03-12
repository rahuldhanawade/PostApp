package com.example.duadm_post.dbhelper

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_posts")
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val userId: Int,
    val body: String,
    var isFavorites: Boolean = false
)