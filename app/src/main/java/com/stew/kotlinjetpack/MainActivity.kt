package com.stew.kotlinjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.stew.kotlinjetpack.lifecycle.TestLifecycleActivity
import com.stew.kotlinjetpack.navigation.TestNavigationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tx1).setOnClickListener {
            startActivity(Intent(this, TestNavigationActivity::class.java))
        }

        findViewById<TextView>(R.id.tx2).setOnClickListener {
            startActivity(Intent(this, TestLifecycleActivity::class.java))
        }

    }
}