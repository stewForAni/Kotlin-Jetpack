package com.stew.kotlinjetpack

import android.app.Application

/**
 * Created by stew on 5/30/22.
 * mail: stewforani@gmail.com
 */
class MyApp:Application() {


    companion object {

        private var INSTANCE: Application? = null

        fun getInstance(): Application = INSTANCE!!
    }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}