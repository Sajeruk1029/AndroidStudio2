package com.example.bottomnavi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigtion.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.fragment_second -> {
                if(Navigation.findNavController(this, R.id.frag).currentDestination?.label != "fragment_second") {

                        Navigation.findNavController(this, R.id.frag)
                            .navigate(R.id.action_firstFragment_to_secondFragment)
                        Log.d("Debug", Navigation.findNavController(this, R.id.frag).currentDestination?.label.toString())

                }
                return true
            }

            R.id.fragment_first -> {
                if(Navigation.findNavController(this, R.id.frag).currentDestination?.label != "fragment_first")
                {
                    Navigation.findNavController(this, R.id.frag).navigate(R.id.action_secondFragment_to_firstFragment)
                    Log.d("Debug", Navigation.findNavController(this, R.id.frag).currentDestination?.label.toString())
                }
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }

        }
    }
}