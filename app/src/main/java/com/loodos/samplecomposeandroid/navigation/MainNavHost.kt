package com.loodos.samplecomposeandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.merttoptas.category.navigation.categoryScreen
import com.merttoptas.home.navigation.homeScreen
import com.merttoptas.home.navigation.navigateToHome
import com.merttoptas.login.navigation.LoginNavigationRoute
import com.merttoptas.login.navigation.loginScreen
import com.merttoptas.productdetail.navigation.navigateToProductDetail
import com.merttoptas.productdetail.navigation.productDetail
import com.merttoptas.profile.navigation.profileScreen

/**
 * Created by mertcantoptas on 10.03.2023
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = LoginNavigationRoute,
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
