package com.stew.kotlinjetpack.mvvmsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by stew on 5/10/22.
 * mail: stewforani@gmail.com
 */
class UserListViewModel : ViewModel() {

    private val userList: MutableLiveData<MutableList<User>> by lazy {
        MutableLiveData<MutableList<User>>()
    }

    private val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getUserLiveData(): LiveData<MutableList<User>> {
        return userList
    }

    fun getLoadingLiveData(): LiveData<Boolean> {
        return isLoading
    }

    fun addUserData() {
        val tmp = userList.value
        tmp?.add(User("bob", "99"))
        userList.value = tmp
    }

    fun deleteUserData() {
        val tmp = userList.value
        tmp?.removeAt(0)
        userList.value = tmp
    }

    fun getUserData() {
        isLoading.value = true
        UserRepository.getUserFromServer(object : DataCallBack<MutableList<User>> {
            override fun onSuccess(data: MutableList<User>) {
                userList.postValue(data)
                isLoading.postValue(false)
            }

            override fun onFailed() {
                isLoading.postValue(false)
            }
        })


    }

}