package com.example.tableone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.tableone.databinding.ActivityMainBinding
import com.example.tableone.ui.DomFragment
import com.example.tableone.ui.RedBookFragment
import com.example.tableone.ui.WildFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP_ACTIVITY = this

        setSupportActionBar(binding.toolbar)
        title = "Животные"

        val VP: ViewPager = binding.viewPager
        val TL: TabLayout = binding.tabLayout

        setupViewPager(VP)
        TL.setupWithViewPager(VP)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        mAdapter = PagerAdapter(supportFragmentManager)
        mAdapter.addFragment((WildFragment()), "Дикие")
        mAdapter.addFragment(DomFragment(), "Домашние")
        mAdapter.addFragment(RedBookFragment(), "Красная Книга")
        viewPager.adapter = mAdapter
    }
}