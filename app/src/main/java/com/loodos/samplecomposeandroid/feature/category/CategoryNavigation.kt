package com.loodos.samplecomposeandroid.feature.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val CategoryRoute = "category_route"

fun NavController.navigateToCategory(navOptions: NavOptions? = null) {
    this.navigate(CategoryRoute, navOptions)
}

fun NavGraphBuilder.categoryScreen() {
    composable(
        route = CategoryRoute,
    ) {
        CategoryRoute()
    }
}
