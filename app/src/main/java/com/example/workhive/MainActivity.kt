package com.example.workhive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.workhive.databinding.ActivityMainBinding
import com.example.workhive.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        showHomeFragment()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> showHomeFragment()
                R.id.nav_discover -> showDiscoverFragment()
                R.id.nav_post -> showPostGigFragment()
                R.id.nav_profile -> showProfileFragment()
            }
            true
        }
    }

    private fun showHomeFragment() = replaceFragment(HomeFragment())
    private fun showDiscoverFragment() = replaceFragment(DiscoverFragment())
    private fun showPostGigFragment() = replaceFragment(PostGigFragment())
    private fun showProfileFragment() = replaceFragment(ProfileFragment())

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}