package com.example.duadm_post.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite_posts")
data class PostDataResponse (

    @SerializedName("userId"        ) var userId : Int?    = null,
    @SerializedName("id"            ) @PrimaryKey(autoGenerate = true) var id     : Int?    = null,
    @SerializedName("title"         ) var title  : String? = null,
    @SerializedName("body"          ) var body   : String? = null,
    @SerializedName("is_favorites"  ) var isFavorites   : Boolean = false

)