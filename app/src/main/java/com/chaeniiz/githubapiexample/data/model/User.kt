package com.chaeniiz.githubapiexample.data.model

import com.google.gson.annotations.SerializedName
import com.chaeniiz.entity.entities.User as Entity

data class User(
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val profile: String
)

fun User.toEntity() = Entity(name, profile)
