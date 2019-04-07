package com.chaeniiz.githubapiexample.presentation.detail

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chaeniiz.githubapiexample.R
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity(), DetailView {

    private val presenter: DetailPresenter by lazy { DetailPresenter(this, this) }

    companion object {
        const val NAME_KEY = "nameKey"

        fun start(context: Context, name: String) {
            context.run {
                startActivity(
                    intentFor<DetailActivity>(
                        NAME_KEY to name
                    )
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter.onCreate(intent.getStringExtra(NAME_KEY))
    }

    override fun showNameTextView(name: String) {
        nameTextView.text = name
    }

    override fun showAvatarUrl(avatarUrl: String) {
        Glide.with(this).load(avatarUrl)
            .apply(RequestOptions().override(500, 500))
            .into(avatarImageView)
    }

    override fun showNickTextView(nickname: String) {
        nickTextView.text = intent.getStringExtra(NAME_KEY)
    }

    override fun showBio(bio: String) {
        bioTextView.text = bio
    }

    override fun showCompany(company: String) {
        companyTextView.text = company
        companyImageView.visibility = View.VISIBLE
        companyTextView.visibility = View.VISIBLE
    }

    override fun showLocation(location: String) {
        locationTextView.text = location
        locationTextView.visibility = View.VISIBLE
        locationImageView.visibility = View.VISIBLE
    }

    override fun showRecentActivity(recentActivity: String) {
        recentActivityTextView.text = recentActivity
        recentActivityTextView.visibility = View.VISIBLE
        recentActivityImageView.visibility = View.VISIBLE
    }

    override fun hideBio() {
        bioTextView.visibility = View.GONE
    }

    override fun hideCompany() {
        companyImageView.visibility = View.GONE
        companyTextView.visibility = View.GONE
    }

    override fun hideLocation() {
        locationTextView.visibility = View.GONE
        locationImageView.visibility = View.GONE
    }

    override fun hideRecentActivity() {
        recentActivityTextView.visibility = View.GONE
        recentActivityImageView.visibility = View.GONE
    }

    override fun showLoading() {
        container.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        container.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showErrorToast() {
        toast(R.string.fetch_data_error)
        finish()
    }
}
