package com.chaeniiz.githubapiexample.presentation.detail

import android.content.Context

class DetailPresenter(
    context: Context,
    val view: DetailView
) {
    fun onCreate() {
        view.setNameTextView()
        view.setAvatarUrl()
    }
}
