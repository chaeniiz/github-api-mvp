package com.chaeniiz.githubapiexample

import android.content.Context
import com.chaeniiz.githubapiexample.data.api.UserApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient(
    context: Context,
    private val baseUrl: String = "https://api.github.com/"
) {
    companion object {
        private var instance: ApiClient? = null

        @Synchronized
        fun getInstance(context: Context): ApiClient {
            if (instance == null) {
                instance = ApiClient(context)
            }
            return instance!!
        }

        @Synchronized
        fun clear() {
            instance = null
        }
    }

    private val adapter: Retrofit by lazy {
        val builder: OkHttpClient.Builder =
            OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(builder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApi: UserApi by lazy {
        adapter.create(UserApi::class.java)
    }
}

val Context.retrofit: ApiClient
    get() = ApiClient.getInstance(applicationContext)