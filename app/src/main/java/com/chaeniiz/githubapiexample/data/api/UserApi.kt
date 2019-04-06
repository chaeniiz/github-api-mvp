package com.chaeniiz.githubapiexample.data.api

import com.chaeniiz.githubapiexample.data.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/users/{userName}")
    fun getUserInfo(@Path("userName") userName: String): Single<User>
}
