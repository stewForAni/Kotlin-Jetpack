package com.stew.kotlinjetpack.navigation

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 4/30/22.
 * mail: stewforani@gmail.com
 */
class TestNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
//        val f = supportFragmentManager.findFragmentById(R.id.my_fragment) as NavHostFragment
//        findViewById<BottomNavigationView>(R.id.bottom_nav_view).setupWithNavController(f.navController)

        findViewById<BottomNavigationView>(R.id.bottom_nav_view).setOnNavigationItemSelectedListener {
            Log.d("TestNavigationActivity", "onCreate: "+it.itemId)
            when(it.itemId){
                R.id.f1 -> return@setOnNavigationItemSelectedListener true
                R.id.f2 -> return@setOnNavigationItemSelectedListener true
                R.id.f3 -> return@setOnNavigationItemSelectedListener true
            }
            false
        }
    }
}