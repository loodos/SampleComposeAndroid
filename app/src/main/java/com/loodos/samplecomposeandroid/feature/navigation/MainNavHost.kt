package com.loodos.samplecomposeandroid.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.loodos.samplecomposeandroid.feature.home.navigation.homeNavigationRoute
import com.loodos.samplecomposeandroid.feature.home.navigation.homeScreen

/**
 * Created by mertcantoptas on 10.03.2023
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen()
    }
}