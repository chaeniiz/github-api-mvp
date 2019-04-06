package com.chaeniiz.entity.entities

import com.chaeniiz.entity.Entity

data class User(
    val name: String,
    val avatarUrl: String
) : Entity
