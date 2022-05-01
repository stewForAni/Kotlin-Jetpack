package com.stew.kotlinjetpack.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 4/30/22.
 * mail: stewforani@gmail.com
 */
class TestNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val f = supportFragmentManager.findFragmentById(R.id.my_fragment) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.bottom_nav_view).setupWithNavController(f.navController)
    }
}