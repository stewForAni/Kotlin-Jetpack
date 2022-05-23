package com.stew.kotlinjetpack.paging3

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
data class GithubProjectItem(
    val id: Int,
    val name: String,
    val description: String?,
    val stargazers_count: Int
)
