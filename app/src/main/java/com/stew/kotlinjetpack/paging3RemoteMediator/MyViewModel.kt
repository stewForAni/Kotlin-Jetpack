package com.stew.kotlinjetpack.paging3RemoteMediator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.stew.kotlinjetpack.room.githubproject.GithubProjectEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by stew on 5/30/22.
 * mail: stewforani@gmail.com
 */

@ExperimentalPagingApi
class MyViewModel :ViewModel(){
    fun getData(): Flow<PagingData<GithubProjectEntity>>{
        return MyRepository.getData().cachedIn(viewModelScope)
    }
}