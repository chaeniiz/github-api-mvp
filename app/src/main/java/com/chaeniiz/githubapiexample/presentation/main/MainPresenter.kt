package com.chaeniiz.githubapiexample.presentation.main

import android.content.Context
import com.chaeniiz.domain.usecases.GetUserInfo
import com.chaeniiz.entity.entities.User
import com.chaeniiz.githubapiexample.data.repositories.UserRepository
import io.reactivex.observers.DisposableSingleObserver

class MainPresenter(
    context: Context,
    val view: MainView,
    private val getUserInfo: GetUserInfo =
        GetUserInfo(UserRepository(context))
) {
    fun onGetUserInfoButtonClicked(name: String) {
        getUserInfo.apply {
            userName = name
        }.execute(object : DisposableSingleObserver<User>() {
            override fun onSuccess(t: User) {
                view.startDetailActivity(t.name, t.avatarUrl)
            }

            override fun onError(e: Throwable) {
                view.showErrorToast()
            }
        })
    }
}
