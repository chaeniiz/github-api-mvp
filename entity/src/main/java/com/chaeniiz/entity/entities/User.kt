package com.chaeniiz.entity.entities

import com.chaeniiz.entity.Entity

data class User(
    val name: String,
    val nickname: String,
    val avatarUrl: String,
    val bio: String?,
    val company: String?,
    val location: String?,
    val recentActivity: String?
) : Entity
