package com.stew.kotlinjetpack.apisample

import retrofit2.http.GET

/**
 * Created by stew on 5/19/22.
 * mail: stewforani@gmail.com
 */
interface Apis {

    companion object{
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    @GET("project/tree/json")
    suspend fun loadProjectTree():BaseResp<List<ProjectTree>>
}