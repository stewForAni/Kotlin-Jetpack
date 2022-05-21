package com.stew.kotlinjetpack.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_SET_USER_VISIBLE_HINT) {

    private val list: MutableList<Fragment> = ArrayList()

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    fun addFragment(fragment: Fragment) {
        list.add(fragment)
    }
}