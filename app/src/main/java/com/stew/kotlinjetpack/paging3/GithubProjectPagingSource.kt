package com.stew.kotlinjetpack.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stew.kotlinjetpack.apisample.RetrofitManager

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class GithubProjectPagingSource : PagingSource<Int, GithubProjectItem>() {
    override fun getRefreshKey(state: PagingState<Int, GithubProjectItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubProjectItem> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        val response = RetrofitManager.getApisTool().getGithubProject(page, pageSize).items
        val prevKey = if (page > 1) page - 1 else null
        val nextKey = if (response.isNotEmpty()) page + 1 else null
        return LoadResult.Page(response, prevKey, nextKey)
    }
}