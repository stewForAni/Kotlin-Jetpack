package com.stew.kotlinjetpack.paging3RemoteMediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.stew.kotlinjetpack.room.AppDatabase
import com.stew.kotlinjetpack.room.githubproject.GithubProjectEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by stew on 5/30/22.
 * mail: stewforani@gmail.com
 */

@ExperimentalPagingApi
object MyRepository {

    private val db = AppDatabase.getInstance()

    fun getData(): Flow<PagingData<GithubProjectEntity>> {
        return Pager(
                config = PagingConfig(pageSize = 10,
                        enablePlaceholders = false,
                        prefetchDistance = 5,
                        initialLoadSize = 20,
                        maxSize = 30),
                remoteMediator = MyRemoteMediator(db),
                pagingSourceFactory = {
                    db.GithubProjectDao().get()
                }
        ).flow
    }

}