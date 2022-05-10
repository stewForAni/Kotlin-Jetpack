package com.stew.kotlinjetpack.mvvmsample

/**
 * Created by stew on 5/10/22.
 * mail: stewforani@gmail.com
 */
interface DataCallBack<T> {
    fun onSuccess(data: T)
    fun onFailed()
}