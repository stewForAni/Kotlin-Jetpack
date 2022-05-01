package com.stew.kotlinjetpack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by stew on 4/30/22.
 * mail: stewforani@gmail.com
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        Thread.sleep(1000)
        startActivity(Intent(this, MainActivity::class.java))
    }
}