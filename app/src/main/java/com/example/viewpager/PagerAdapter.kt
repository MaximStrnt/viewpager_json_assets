package com.example.tableone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragmentList: MutableList<Fragment> = ArrayList<Fragment>()
    private val fragmentTitles: MutableList<String> = ArrayList<String>()

    override fun getCount(): Int {
        return fragmentList.size

    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }


    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitles.add(title)
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

}