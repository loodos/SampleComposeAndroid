package com.loodos.samplecomposeandroid.feature.navigation

import com.loodos.samplecomposeandroid.R
import com.loodos.samplecomposeandroid.core.designsystem.AppIcons
import com.loodos.samplecomposeandroid.core.designsystem.Icon
import com.loodos.samplecomposeandroid.core.designsystem.Icon.ImageVectorIcon
import com.loodos.samplecomposeandroid.feature.category.CategoryRoute
import com.loodos.samplecomposeandroid.feature.home.navigation.HomeNavigationRoute
import com.loodos.samplecomposeandroid.feature.profile.ProfileRoute

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val titleTextId: Int,
) {
    HOME(
        route = HomeNavigationRoute,
        selectedIcon = ImageVectorIcon(AppIcons.Home),
        unselectedIcon = ImageVectorIcon(AppIcons.HomeOutlined),
        titleTextId = R.string.nav_home_title,
    ),
    CATEGORY(
        route = CategoryRoute,
        selectedIcon = ImageVectorIcon(AppIcons.Category),
        unselectedIcon = ImageVectorIcon(AppIcons.CategoryOutlined),
        titleTextId = R.string.nav_category_title,
    ),
    PROFILE(
        route = ProfileRoute,
        selectedIcon = ImageVectorIcon(AppIcons.Person),
        unselectedIcon = ImageVectorIcon(AppIcons.PersonOutlined),
        titleTextId = R.string.nav_profile_title,
        ),
}
