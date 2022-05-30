package com.stew.kotlinjetpack.paging3

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stew.kotlinjetpack.apisample.RetrofitManager
import java.lang.Exception

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class GithubProjectPagingSource : PagingSource<Int, GithubProjectItem>() {
    override fun getRefreshKey(state: PagingState<Int, GithubProjectItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubProjectItem> {
        return try {
            Log.d("PagingSource", "params.key: " + params.key)
            val page = params.key ?: 1 //从1开始，无法显示Header
            val pageSize = params.loadSize
            val response = RetrofitManager.getApisTool().getGithubProject(page, pageSize)
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (response.items.isNotEmpty()) page + 1 else null
            LoadResult.Page(response.items, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}