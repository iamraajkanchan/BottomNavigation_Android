package com.example.bottomnavigation_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigation_android.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(homeFragment)

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> setCurrentFragment(homeFragment)
                R.id.menuProfile -> setCurrentFragment(profileFragment)
                R.id.menuSettings -> setCurrentFragment(settingsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer, fragment)
            commit()
        }
    }


}