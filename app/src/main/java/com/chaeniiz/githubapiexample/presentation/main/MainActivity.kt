package com.chaeniiz.githubapiexample.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chaeniiz.githubapiexample.R
import com.chaeniiz.githubapiexample.presentation.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    private val presenter: MainPresenter by lazy { MainPresenter(this, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUserInfoButton.setOnClickListener {
            presenter.onGetUserInfoButtonClicked(nameInputEditText.text.toString())
        }
    }

    override fun startDetailActivity(name: String) {
        DetailActivity.start(this, name)
    }

    override fun showErrorToast() {
        toast(getString(R.string.fetch_data_error))
    }
}
