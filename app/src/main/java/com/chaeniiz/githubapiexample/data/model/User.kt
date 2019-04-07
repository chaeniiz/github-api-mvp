package com.chaeniiz.githubapiexample.data.model

import com.google.gson.annotations.SerializedName
import com.chaeniiz.entity.entities.User as Entity

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("login") val nickName: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("bio") val bio: String?,
    @SerializedName("company") val company: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("updated_at") val recentActivity: String?
)

fun User.toEntity() = Entity(name, nickName, avatarUrl, bio, company, location, recentActivity)
