package com.example.tasktimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.ButtonBarLayout
import androidx.fragment.app.Fragment
import com.example.tasktimer.fragments.AddTaskFragment

class MainActivity : AppCompatActivity() {
    private val HomeScreenFragment = com.example.tasktimer.fragments.HomeScreenFragment()
    private val PrograssFragment = com.example.tasktimer.fragments.PrograssFragment()
    private val AddTaskFragment = com.example.tasktimer.fragments.AddTaskFragment()
    lateinit var bottomNav : ButtonBarLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomeScreenFragment)

//        bottomNav = findViewById(R.id.bottom_navigation)
            bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.ic_home -> replaceFragment(HomeScreenFragment)
                R.id.ic_progress -> replaceFragment(PrograssFragment)
                R.id.ic_add -> replaceFragment(AddTaskFragment)
            }
            true
        } //setOnNavigationItemSelectedListener
    }

    private fun replaceFragment (fragment : Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_tag, fragment)
            transaction.commit()
        }
    }
}