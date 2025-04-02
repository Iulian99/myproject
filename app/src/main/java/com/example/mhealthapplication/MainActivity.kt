package com.example.mhealthapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.mhealthapplication.ConsumFragment.ConsumFragment
import com.example.mhealthapplication.home.HomeFragment
import com.example.mhealthapplication.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()


        bottomNavigationView = findViewById(R.id.bottom_navigation)
        frameLayout = findViewById(R.id.frame_layout)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            navigationBar(item)
        }

        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit()
        }
    }

    // Navigare între fragmente pe baza itemului selectat din BottomNavigationView
    private fun navigationBar(it: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (it.itemId) {
            R.id.action_home -> fragment = HomeFragment()
            R.id.action_consum -> fragment = ConsumFragment()
            R.id.action_settings -> fragment = SettingsFragment()
        }

        fragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, it)
                .commit()
        }

        return true
    }
//    private fun navigationBar(it: MenuItem) : Boolean{
//        when (it.itemId) {
//            R.id.action_home -> {
//                val fragment = HomeFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
//                    .commit()
//            }
//            R.id.action_consum -> {
//                val fragment = ConsumFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
//                    .commit()
//            }
//            R.id.action_settings -> {
//                val fragment = SettingsFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
//                    .commit()
//            }
//        }
//        return true
//    }

}