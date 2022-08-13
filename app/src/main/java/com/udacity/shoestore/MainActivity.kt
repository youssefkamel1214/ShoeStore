package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var biding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        setContentView(biding.root)
        setSupportActionBar(biding.toolbar)
        val navController =this.findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        biding.toolbar.setupWithNavController(navController,appBarConfiguration)
        navController.addOnDestinationChangedListener {
                controller,destionation,_->
            if(destionation.id ==R.id.homeFragment||destionation.id==R.id.loginFragment2) {
                supportActionBar!!.setDisplayShowHomeEnabled(false)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                supportActionBar!!.setHomeButtonEnabled(false)
                toolbar.navigationIcon=null
            }
            else{
                supportActionBar!!.setDisplayShowHomeEnabled(true)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setHomeButtonEnabled(true)
            }
        }
        Timber.plant(Timber.DebugTree())
    }
}
