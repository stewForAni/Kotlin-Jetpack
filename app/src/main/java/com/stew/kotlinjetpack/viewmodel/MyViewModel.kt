package com.stew.kotlinjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by stew on 5/5/22.
 * mail: stewforani@gmail.com
 */
class MyViewModel : ViewModel() {

    private val userData: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>().also {
            getData()
        }
    }

    private fun getData() {
        Thread {
            Thread.sleep(3000)
            userData.postValue(listOf("Stew", "Helen", "Bob", "Lucy"))
            Thread.sleep(3000)
            userData.postValue(listOf("Stew", "Helen", "Bob"))
        }.start()
    }

    fun getUserData(): LiveData<List<String>> {
        return userData
    }

}




