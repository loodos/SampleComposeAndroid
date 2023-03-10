package com.loodos.samplecomposeandroid.feature.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.loodos.samplecomposeandroid.feature.home.HomeScreen

/**
 * Created by mertcantoptas on 10.03.2023
 */
const val homeNavigationRoute = "home_route"

fun NavController.navigateHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeRoute(
    modifier: Modifier
) {
    composable(route = homeNavigationRoute) {
        /*
         val viewModel = hiltViewModel<HomeViewModel>()
        val homeUiState by viewModel.uiState.collectAsStateWithLifecycle()
         */

        HomeScreen(
            modifier = modifier,
        )
    }
}