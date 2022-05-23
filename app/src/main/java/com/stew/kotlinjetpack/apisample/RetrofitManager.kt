package com.stew.kotlinjetpack.apisample

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by stew on 5/18/22.
 * mail: stewforani@gmail.com
 */
object RetrofitManager {

    private var apis: Apis

    fun getApisTool(): Apis {
        return apis
    }

    init {
        val loggingInterceptor = HttpLoggingInterceptor {
            Log.d("http log : ", it)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okClient = OkHttpClient().newBuilder()
                .callTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(false)
                .addInterceptor(loggingInterceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .client(okClient)
                .baseUrl(Apis.GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apis = retrofit.create(Apis::class.java)
    }

}