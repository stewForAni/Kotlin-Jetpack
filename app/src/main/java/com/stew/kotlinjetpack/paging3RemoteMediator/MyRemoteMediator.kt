package com.stew.kotlinjetpack.paging3RemoteMediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.stew.kotlinjetpack.room.githubproject.GithubProjectEntity

/**
 * Created by stew on 5/29/22.
 * mail: stewforani@gmail.com
 */
@OptIn(ExperimentalPagingApi::class)
class MyRemoteMediator : RemoteMediator<Int, GithubProjectEntity>() {
    override suspend fun load(
            loadType: LoadType,
            state: PagingState<Int, GithubProjectEntity>,
    ): MediatorResult {


        val pageKey = when (loadType) {
            LoadType.REFRESH -> {
                 null
            }
            LoadType.PREPEND -> {
                MediatorResult.Success(endOfPaginationReached = true)
            }
            LoadType.APPEND -> {
val lastItem = state.lastItemOrNull()
                if (lastItem==null){
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                return lastItem.
            }
        }

        TODO("Not yet implemented")
    }
}