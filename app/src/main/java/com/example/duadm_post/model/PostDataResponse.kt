package com.example.duadm_post.model

import com.google.gson.annotations.SerializedName

data class PostDataResponse (

    @SerializedName("userId"        ) var userId : Int?    = null,
    @SerializedName("id"            ) var id     : Int?    = null,
    @SerializedName("title"         ) var title  : String? = null,
    @SerializedName("body"          ) var body   : String? = null,
    @SerializedName("is_favorites"  ) var isFavorites   : Boolean = false

)