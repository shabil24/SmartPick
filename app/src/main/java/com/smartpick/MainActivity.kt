package com.smartpick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.smartpick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    navController.navigate(R.id.navigation_dashboard)
                    true
                }
                R.id.navigation_home, R.id.navigation_notifications -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                else -> false
            }
        }

        // Tambahan penting agar PNG tidak kena tint!
        binding.navView.itemIconTintList = null
        binding.navView.itemTextColor = null

        val destination = intent.getIntExtra("navigate_to", R.id.navigation_dashboard)
        if (savedInstanceState == null) {
            navController.navigate(destination)
            binding.navView.selectedItemId = destination
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_activity_main)
            .navigateUp() || super.onSupportNavigateUp()
    }
}