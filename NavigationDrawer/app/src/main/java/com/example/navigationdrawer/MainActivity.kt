package com.example.navigationdrawer

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigationView.setOnNavigationItemSelectedListener(this)
        
        //Navigation.findNavController(this, R.id.fragment).navigate(R.id.fragment_second)
        //NavigationUI.setupWithNavController(navigationView, Navigation.findNavController(this, R.id.fragment))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val itemid: Int = item.itemId

        when (itemid) {
            R.id.on_fragment_one -> {

                //if(Navigation.findNavController(this, R.id.fragment).currentDestination?.label != ""){
                    //Navigation.findNavController(this, R.id.fragment)
                        //.navigate(R.id.action_fragment_first_to_fragment_second)
                        Log.d("Debug", Navigation.findNavController(this, R.id.fragment).currentDestination?.label.toString())
                //}
                return true
            }

            R.id.on_fragment_two -> {
                //Navigation.findNavController(this, R.id.fragment)
                    //.navigate(R.id.action_fragment_second_to_fragment_first)
                Log.d("Debug", Navigation.findNavController(this, R.id.fragment).currentDestination?.label.toString())
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        val inflater: MenuInflater = menuInflater

        inflater.inflate(R.menu.menu, menu)

        return true

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.on_fragment_one -> {
                if(Navigation.findNavController(this, R.id.fragment).currentDestination?.label.toString() != "fragment_second") {
                    Navigation.findNavController(this, R.id.fragment).navigate(R.id.action_fragment_first_to_fragment_second)
                    Log.d("Debug", Navigation.findNavController(this, R.id.fragment).currentDestination?.label.toString())
                }
                return true
            }

            R.id.on_fragment_two -> {
                if(Navigation.findNavController(this, R.id.fragment).currentDestination?.label.toString() != "fragment_first") {
                    Navigation.findNavController(this, R.id.fragment).navigate(R.id.action_fragment_second_to_fragment_first)
                    Log.d("Debug", Navigation.findNavController(this, R.id.fragment).currentDestination?.label.toString())
                }
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
