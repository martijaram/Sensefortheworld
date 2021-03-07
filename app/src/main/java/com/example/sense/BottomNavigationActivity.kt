package com.example.sense

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sense.FragmentClasses.ClassesFragment
import com.example.sense.FragmentClasses.HomeFragment
import com.example.sense.FragmentClasses.ProfileFragment
import com.example.sense.FragmentClasses.ShopFragment

class BottomNavigationActivity : AppCompatActivity() {

    // create three objects for fragments as create in java
    var homeFragment: HomeFragment? = null
    var profileFragment: ProfileFragment? = null
    var shopFragment: ShopFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Home fragment is default fragment
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment!!).commit()

        // Setting up bottoms and their classes
        bottomNavigationView.setOnNavigationItemSelectedListener{item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment!!).commit()
                }
                R.id.navigation_profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, profileFragment!! as Fragment).commit()
                }
                R.id.navigation_shop -> {
                    shopFragment = ShopFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, shopFragment!!).commit()
                }
            }
            true
        }


    }
}
