package com.chaeniiz.domain.repository

import com.chaeniiz.entity.entities.User
import io.reactivex.Single

interface UserRepository : Repository {
    fun getUserInfo(userName: String): Single<User>
}
