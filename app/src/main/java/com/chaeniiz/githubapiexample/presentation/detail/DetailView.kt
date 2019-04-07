package com.chaeniiz.githubapiexample.presentation.detail

interface DetailView {
    fun showAvatarUrl(avatarUrl: String)
    fun showNameTextView(name: String)
    fun showNickTextView(nickname: String)
    fun showBio(bio: String)
    fun showCompany(company: String)
    fun showLocation(location: String)
    fun showRecentActivity(recentActivity: String)
    fun hideBio()
    fun hideCompany()
    fun hideLocation()
    fun hideRecentActivity()
    fun showLoading()
    fun dismissLoading()
    fun showErrorToast()
}
