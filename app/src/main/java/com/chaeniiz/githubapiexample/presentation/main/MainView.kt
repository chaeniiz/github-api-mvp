package com.chaeniiz.githubapiexample.presentation.main

interface MainView {
    fun startDetailActivity(name: String, avatarUrl: String)
    fun showErrorToast()
}