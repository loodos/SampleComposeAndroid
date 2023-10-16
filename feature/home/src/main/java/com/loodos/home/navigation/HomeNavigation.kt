package com.loodos.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.loodos.home.HomeScreenRoute

/**
 * Created by mertcantoptas on 10.03.2023
 */
const val HomeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(HomeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToDetail: (Int) -> Unit,
) {
    composable(route = HomeNavigationRoute) {
        HomeScreenRoute(
            navigateToDetail = navigateToDetail,
        )
    }
}
