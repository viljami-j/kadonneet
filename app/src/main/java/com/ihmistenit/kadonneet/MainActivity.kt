package com.ihmistenit.kadonneet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.ihmistenit.kadonneet.databinding.ActivityMainBinding
import com.ihmistenit.kadonneet.ui.user_advert.UserAdvertListFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val test = supportFragmentManager.findFragmentByTag(UserAdvertListFragment::class.java.name)
        if (test == null) println("elontusk")

        val userAdvertRecyclerView: RecyclerView? = supportFragmentManager.findFragmentById(R.id.tabContentFragContainer)?.view?.findViewById(R.id.user_advert_recyclerview)
        if (userAdvertRecyclerView != null) {
            userAdvertRecyclerView.setOnClickListener(View.OnClickListener {
                println("Hello!")
            })
        } else println("MainActivity.kt: Couldn't find userAdvertRecyclerView (Is it not occupying the tabContentFragmentPlaceholder at the moment?)")

        // Setup bottom navigation
        val navView: BottomNavigationView = binding.bottomNavView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_bottom_nav) as NavHostFragment
        navView.setupWithNavController(navHostFragment.navController)
        navView.bringToFront()

        // Setup report finding fab
        val fab: FloatingActionButton? = binding?.fabReportFinding ?: null
        if (fab != null) {
            fab.bringToFront()
            fab.setOnClickListener {
                Snackbar.make(binding.root, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_bottom_nav)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}