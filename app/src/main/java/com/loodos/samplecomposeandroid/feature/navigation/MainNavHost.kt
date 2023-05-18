package com.loodos.samplecomposeandroid.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import com.loodos.samplecomposeandroid.feature.home.navigation.homeNavigationRoute
import com.loodos.samplecomposeandroid.feature.home.navigation.homeScreen
import com.loodos.samplecomposeandroid.feature.home.navigation.navigateHomeScreen
import com.loodos.samplecomposeandroid.feature.login.navigation.loginNavigationRoute
import com.loodos.samplecomposeandroid.feature.login.navigation.loginScreen

/**
 * Created by mertcantoptas on 10.03.2023
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = loginNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen()
        loginScreen(navigateToHome = {
            navController.navigateHomeScreen(
                navOptions =
                NavOptions.Builder()
                    .setPopUpTo(homeNavigationRoute, true)
                    .build()
            )
        })
    }
}