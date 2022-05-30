package com.stew.kotlinjetpack.paging3RemoteMediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.stew.kotlinjetpack.apisample.RetrofitManager
import com.stew.kotlinjetpack.room.AppDatabase
import com.stew.kotlinjetpack.room.githubproject.GithubProjectEntity

/**
 * Created by stew on 5/29/22.
 * mail: stewforani@gmail.com
 */
@OptIn(ExperimentalPagingApi::class)
class MyRemoteMediator(
    private val db: AppDatabase,
) : RemoteMediator<Int, GithubProjectEntity>() {

    val TAG = "MyRemoteMediator"

    private var nextKey = 0

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GithubProjectEntity>,
    ): MediatorResult {

        try {


            val pageKey: Int? = when (loadType) {
                LoadType.REFRESH -> {
                    Log.d(TAG, "LoadType.REFRESH")
                    null
                }
                LoadType.PREPEND -> {
                    Log.d(TAG, "LoadType.PREPEND")
                    return MediatorResult.Success(true)
                }
                LoadType.APPEND -> {
                    Log.d(TAG, "LoadType.APPEND")
                    if (nextKey == -1) {
                        Log.d(TAG, "LoadType.APPEND 1")
                        return MediatorResult.Success(true)
                    }
                    Log.d(TAG, "LoadType.APPEND 2")
                    nextKey
                }
            }

            Log.d(TAG, "nextKey: $nextKey")

            val page = pageKey ?: 1
            val remoteData = RetrofitManager.getApisTool().getGithubProject2(page, 5).items
            val isEnd = remoteData.isEmpty()

            if (loadType == LoadType.REFRESH) {
                db.GithubProjectDao().clear()
            }
            nextKey = if (isEnd) -1 else page + 1

            db.GithubProjectDao().insert(remoteData)
            return MediatorResult.Success(isEnd)

        } catch (e:Exception) {
            return MediatorResult.Error(e)
        }
    }
}