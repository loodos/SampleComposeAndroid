package com.loodos.samplecomposeandroid.navigation

import com.loodos.designsystems.icon.AppIcons
import com.loodos.designsystems.icon.Icon
import com.loodos.samplecomposeandroid.R
import com.merttoptas.category.navigation.CategoryRoute
import com.merttoptas.home.navigation.HomeNavigationRoute
import com.merttoptas.profile.navigation.ProfileRoute

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val titleTextId: Int,
) {
    HOME(
        route = HomeNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Home),
        unselectedIcon = Icon.ImageVectorIcon(AppIcons.HomeOutlined),
        titleTextId = R.string.nav_home_title,
    ),
    CATEGORY(
        route = CategoryRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Category),
        unselectedIcon = Icon.ImageVectorIcon(AppIcons.CategoryOutlined),
        titleTextId = R.string.nav_category_title,
    ),
    PROFILE(
        route = ProfileRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Person),
        unselectedIcon = Icon.ImageVectorIcon(AppIcons.PersonOutlined),
        titleTextId = R.string.nav_profile_title,
    ),
}
