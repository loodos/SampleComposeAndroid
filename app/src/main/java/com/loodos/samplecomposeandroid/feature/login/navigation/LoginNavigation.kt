package com.loodos.samplecomposeandroid.feature.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.loodos.samplecomposeandroid.feature.login.LoginScreenRoute

/**
 * Created by mertcantoptas on 10.05.2023
 */

const val loginNavigationRoute = "login_route"

fun NavController.navigateLoginScreen(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(navigateToHome: () -> Unit) {
    composable(loginNavigationRoute) {
        LoginScreenRoute(navigateToHome = navigateToHome)
    }
}