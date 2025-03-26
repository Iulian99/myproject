package com.example.mhealthapplication

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var frameLayout: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        frameLayout = findViewById(R.id.frame_layout)


//        bottomNavigationView.setSelectedItemId(R.id.fragment_home);

        bottomNavigationView.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.action_home -> {
                        val fragment = HomeFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.getSimpleName())
                            .commit()
                }
                R.id.action_consum -> {
                    val fragment = ConsumFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                }
                R.id.action_settings -> {
                    val fragment = SettingsFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                }
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bottomNavigationView : BottomNavigationView
    }

}