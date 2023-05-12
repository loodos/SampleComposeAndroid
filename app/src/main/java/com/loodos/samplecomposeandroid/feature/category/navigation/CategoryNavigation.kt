package com.loodos.samplecomposeandroid.feature.category.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.loodos.samplecomposeandroid.feature.category.CategoryScreenRoute


const val categoryNavigationRoute = "category_route"

fun NavController.navigateCategoryScreen(navOptions: NavOptions? = null) {
    this.navigate(categoryNavigationRoute, navOptions)
}

fun NavGraphBuilder.categoryScreen() {
    composable(route = categoryNavigationRoute) {
        CategoryScreenRoute()
    }
}