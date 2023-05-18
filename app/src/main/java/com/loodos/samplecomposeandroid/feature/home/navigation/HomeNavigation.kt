package com.loodos.samplecomposeandroid.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.loodos.samplecomposeandroid.feature.home.HomeScreenRoute

/**
 * Created by mertcantoptas on 10.03.2023
 */
const val HomeNavigationRoute = "home_route"

fun NavController.navigateHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(HomeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = HomeNavigationRoute) {
        HomeScreenRoute()
    }
}
