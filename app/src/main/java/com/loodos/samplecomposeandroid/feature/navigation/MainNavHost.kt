package com.loodos.samplecomposeandroid.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.loodos.samplecomposeandroid.feature.category.categoryScreen
import com.loodos.samplecomposeandroid.feature.home.navigation.HomeNavigationRoute
import com.loodos.samplecomposeandroid.feature.home.navigation.homeScreen
import com.loodos.samplecomposeandroid.feature.home.navigation.navigateToHome
import com.loodos.samplecomposeandroid.feature.login.navigation.LoginNavigationRoute
import com.loodos.samplecomposeandroid.feature.login.navigation.loginScreen
import com.loodos.samplecomposeandroid.feature.profile.profileScreen

/**
 * Created by mertcantoptas on 10.03.2023
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HomeNavigationRoute,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen(
            navigateToDetail = { id ->
            },
        )
        loginScreen(navigateToHome = {
            navController.navigateToHome(
                navOptions = navOptions {
                    popUpTo(LoginNavigationRoute) {
                        inclusive = true
                    }
                },
            )
        })
        categoryScreen()
        profileScreen()
    }
}
