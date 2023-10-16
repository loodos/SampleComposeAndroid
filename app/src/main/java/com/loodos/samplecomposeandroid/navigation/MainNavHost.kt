package com.loodos.samplecomposeandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.loodos.category.navigation.categoryScreen
import com.loodos.home.navigation.HomeNavigationRoute
import com.loodos.home.navigation.homeScreen
import com.loodos.home.navigation.navigateToHome
import com.loodos.login.navigation.LoginNavigationRoute
import com.loodos.login.navigation.loginScreen
import com.loodos.productdetail.navigation.navigateToProductDetail
import com.loodos.productdetail.navigation.productDetail
import com.loodos.profile.navigation.profileScreen

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
                navController.navigateToProductDetail(id = id)
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
        productDetail()
    }
}
