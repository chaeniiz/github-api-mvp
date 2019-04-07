package com.chaeniiz.githubapiexample.data.repositories

import android.content.Context
import com.chaeniiz.domain.repository.UserRepository
import com.chaeniiz.entity.entities.User
import com.chaeniiz.githubapiexample.data.model.toEntity
import com.chaeniiz.githubapiexample.data.retrofit
import io.reactivex.Single

class UserRepository(val context: Context) : UserRepository {
    override fun getUserInfo(userName: String): Single<User> =
        context.retrofit.userApi.getUserInfo(userName)
            .map { it.toEntity() }
}
