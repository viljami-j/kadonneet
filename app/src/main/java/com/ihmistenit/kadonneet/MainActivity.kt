package com.ihmistenit.kadonneet

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar
import com.ihmistenit.kadonneet.databinding.ActivityMainBinding
import com.ihmistenit.kadonneet.ui.user_advert.UserAdvertListFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    fun evaluateThemePreference(newVal: Any): Boolean {
        if (newVal == "auto") AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        if (newVal == "day") AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (newVal == "night") AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val themePreference = PreferenceManager.getDefaultSharedPreferences(applicationContext).getString("theme", "auto")
        if (themePreference != null) evaluateThemePreference(themePreference)

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
        navView.menu.findItem(R.id.nav_report_finding).isEnabled = false

        // Setup report finding fab
        val fab: FloatingActionButton = binding.fabReportFinding
        fab.bringToFront()
        fab.setOnClickListener {
            Snackbar.make(binding.root, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_bottom_nav)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}