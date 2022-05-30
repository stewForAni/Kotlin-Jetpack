package com.stew.kotlinjetpack.apisample

import com.stew.kotlinjetpack.paging3.GithubProject
import com.stew.kotlinjetpack.room.githubproject.GithubProjectList
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by stew on 5/19/22.
 * mail: stewforani@gmail.com
 */
interface Apis {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
        const val GITHUB_BASE_URL = "https://api.github.com/"
    }

    @GET("project/tree/json")
    suspend fun loadProjectTree(): BaseResp<List<ProjectTree>>

    @GET("search/repositories?sort=stars&q=Android")
    suspend fun getGithubProject(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): GithubProject

    @GET("search/repositories?sort=stars&q=Android")
    suspend fun getGithubProject2(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): GithubProjectList
}