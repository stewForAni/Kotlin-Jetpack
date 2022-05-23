package com.stew.kotlinjetpack.paging3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class GithubProjectViewmodel : ViewModel() {
    fun getData(): Flow<PagingData<GithubProjectItem>> {
        return GithubRepository.getData().cachedIn(viewModelScope)
    }
}