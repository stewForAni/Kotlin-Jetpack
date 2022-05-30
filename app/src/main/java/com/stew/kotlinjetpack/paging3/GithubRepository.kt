package com.stew.kotlinjetpack.paging3

import androidx.paging.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
object GithubRepository {

    private const val PAGE_SIZE = 5

    private fun a(): GithubProjectPagingSource {
        return GithubProjectPagingSource()
    }

    fun getData(): Flow<PagingData<GithubProjectItem>> {
        return Pager(
            PagingConfig(PAGE_SIZE), null, GithubRepository::a
        ).flow
    }

}