package com.chaeniiz.githubapiexample.presentation.detail

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.chaeniiz.githubapiexample.R
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.intentFor

class DetailActivity : AppCompatActivity(), DetailView {

    private val presenter: DetailPresenter by lazy { DetailPresenter(this, this) }

    companion object {
        const val NAME_KEY = "nameKey"
        const val AVATAR_URL_KEY = "avatarUrlKey"

        fun start(context: Context, name: String, avatarUrl: String) {
            context.run {
                startActivity(
                    intentFor<DetailActivity>(
                        NAME_KEY to name,
                        AVATAR_URL_KEY to avatarUrl
                    )
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter.onCreate()
    }

    override fun setNameTextView() {
        nameTextView.text = intent.getStringExtra(NAME_KEY)
    }

    override fun setAvatarUrl() {
        Glide.with(this).load(Uri.parse(intent.getStringExtra(AVATAR_URL_KEY)))
            .into(avatarImageView)
    }
}
