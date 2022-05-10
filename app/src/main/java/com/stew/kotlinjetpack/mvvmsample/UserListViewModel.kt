package com.stew.kotlinjetpack.mvvmsample

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by stew on 5/10/22.
 * mail: stewforani@gmail.com
 */
class UserListViewModel : ViewModel() {

    private val userList: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>()
    }

    private val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getUserLiveData(): MutableLiveData<List<User>> {
        return userList
    }

    fun getLoadingLiveData(): MutableLiveData<Boolean> {
        return isLoading
    }

    fun getUserData() {
        isLoading.value = true

        UserRepository.get().getUserFromServer(object :DataCallBack<List<User>>{
            override fun onSuccess(data: List<User>) {
                userList.postValue(data)
                isLoading.postValue(false)
            }

            override fun onFailed() {
                isLoading.postValue(false)
            }
        })
    }

}