package com.stew.kotlinjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by stew on 5/6/22.
 * mail: stewforani@gmail.com
 */
class SharedViewModel : ViewModel() {
    private val sharedData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getData(s: String) {
        sharedData.value = s
    }

    fun getSharedData(): LiveData<String> {
        return sharedData
    }
}


