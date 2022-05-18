package com.stew.kotlinjetpack.apisample

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Created by stew on 5/18/22.
 * mail: stewforani@gmail.com
 */
object RetrofitManager {

    lateinit var okClient: OkHttpClient
    lateinit var retrofit: Retrofit

    fun init() {
        okClient = OkHttpClient().newBuilder()
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .followRedirects(false)
            .addInterceptor(HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    TODO("Not yet implemented")
                }

            }))
            .build()
    }

}