package com.chaeniiz.githubapiexample.presentation.detail

import android.content.Context
import com.chaeniiz.domain.usecases.GetUserInfo
import com.chaeniiz.entity.entities.User
import com.chaeniiz.githubapiexample.data.repositories.UserRepository
import io.reactivex.observers.DisposableSingleObserver

class DetailPresenter(
    context: Context,
    val view: DetailView,
    private val getUserInfo: GetUserInfo =
        GetUserInfo(UserRepository(context))
) {
    fun onCreate(name: String) {
        view.showLoading()
        getUserInfo.apply {
            userName = name
        }.execute(object : DisposableSingleObserver<User>() {
            override fun onSuccess(t: User) {
                view.showAvatarUrl(t.avatarUrl)
                view.showNameTextView(t.name)
                view.showNickTextView(t.nickname)
                t.bio?.let {
                    view.showBio(it)
                } ?: view.hideBio()
                t.company?.let {
                    view.showCompany(it)
                } ?: view.hideCompany()
                t.location?.let {
                    view.showLocation(it)
                } ?: view.hideLocation()
                t.recentActivity?.let {
                    view.showRecentActivity(it.format("yyyy-MM-dd"))
                } ?: view.hideRecentActivity()
                view.dismissLoading()
            }

            override fun onError(e: Throwable) {
                view.showErrorToast()
            }
        })
    }
}
