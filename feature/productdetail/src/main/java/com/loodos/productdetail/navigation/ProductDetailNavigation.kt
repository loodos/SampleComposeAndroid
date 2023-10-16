package com.loodos.productdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.loodos.productdetail.ProductDetailRoute

const val productDetailRoute = "productDetail_route"
const val idArg = "id"

fun NavController.navigateToProductDetail(id: Int, navOptions: NavOptions? = null) {
    this.navigate(productDetailRoute.plus("/$id"), navOptions)
}

fun NavGraphBuilder.productDetail() {
    composable(
        route = productDetailRoute.plus("/{$idArg}"),
        arguments = listOf(
            navArgument(idArg) {
                type = NavType.IntType
            },
        ),
    ) {
        ProductDetailRoute()
    }
}
