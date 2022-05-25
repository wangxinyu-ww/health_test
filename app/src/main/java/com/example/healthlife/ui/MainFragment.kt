package com.example.healthlife.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.healthlife.R
import com.example.healthlife.base.fragment.BaseViewBindingFragment
import com.example.healthlife.databinding.FragmentMainBinding

class MainFragment : BaseViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(
            R.id.nav_main_fragment
        ) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph_main)
        navGraph.setStartDestination(R.id.navigation_home_fragment)
        viewBinding.bottomNav.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home_fragment,
                R.id.navigation_sport_fragment,
                R.id.navigation_find_fragment,
                R.id.navigation_heart_rate_fragment,
                R.id.navigation_mine_fragment
            )
        )
        NavigationUI.setupWithNavController(
            requireActivity().findViewById(R.id.toolbar),
            navController,
            appBarConfiguration
        )
    }
}