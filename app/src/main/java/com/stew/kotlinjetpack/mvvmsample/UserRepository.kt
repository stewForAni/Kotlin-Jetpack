package com.stew.kotlinjetpack.mvvmsample

import androidx.annotation.MainThread


/**
 * Created by stew on 5/10/22.
 * mail: stewforani@gmail.com
 */
class UserRepository {

    companion object {
        lateinit var sInstance: UserRepository

        @MainThread
        fun get(): UserRepository {
            sInstance = if (this::sInstance.isInitialized) sInstance else UserRepository()
            return sInstance
        }
    }


    fun getUserFromServer(c: DataCallBack<List<User>>) {
        Thread {
            Thread.sleep(2000)
            val list = ArrayList<User>()
            for (index in 1..10) {
                val a = User()
                a.name = "stew"
                a.age = "30"
                list.add(a)
            }
            c.onSuccess(list)
            //存本地数据库
            //saveUsersToLocal(users);
        }.start()
    }

    //从本地数据库获取
    fun getUsersFromLocal() {

    }

    //存入本地数据库 (从服务端获取数据后可以调用)
    fun saveUsersToLocal() {

    }

}