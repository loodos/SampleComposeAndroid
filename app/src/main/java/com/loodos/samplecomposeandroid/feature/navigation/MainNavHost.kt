package com.loodos.samplecomposeandroid.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.loodos.samplecomposeandroid.feature.home.navigation.homeNavigationRoute
import com.loodos.samplecomposeandroid.feature.home.navigation.homeRoute

/**
 * Created by mertcantoptas on 10.03.2023
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        homeRoute(modifier = modifier)
    }
}