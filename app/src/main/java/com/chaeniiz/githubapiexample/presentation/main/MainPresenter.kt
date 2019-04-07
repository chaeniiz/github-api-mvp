package com.chaeniiz.githubapiexample.presentation.main

import android.content.Context

class MainPresenter(
    context: Context,
    val view: MainView
) {
    fun onGetUserInfoButtonClicked(name: String) {
        view.startDetailActivity(name)
    }
}
