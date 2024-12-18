package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.example.newproject.fragment.HomeFragment
import com.example.newproject.fragment.ShopsFragment
import com.example.newproject.profile.ProfileFragment
import com.example.newproject.fragment.ScannerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNavigationView:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.addFab)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_restaurant -> {
                    replaceFragment(ShopsFragment())
                    title = "Notification"
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    title = "Home"
                }
                R.id.nav_scanner -> {
                    replaceFragment(ScannerFragment())
                    title = "Setting"
                }
            }
            true
        }

        replaceFragment(HomeFragment())
        title = "Home"
        bottomNavigationView.selectedItemId = R.id.nav_home


    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }

    private fun hideFloatingBtn(){
        fab.hide()
        val menu: Menu = bottomNavigationView.menu
        menu.findItem(R.id.fab)?.isVisible = false
    }
}