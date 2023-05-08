#set($ScreenNameLowerCase = $ScreenName.toLowerCase())
#set($ScreenNameCapLowerCase = $ScreenName.substring(0,1).toLowerCase() + $ScreenName.substring(1))
package ${PACKAGE_NAME}

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val ${ScreenNameCapLowerCase}Route = "${ScreenNameCapLowerCase}_route"

fun NavController.navigateTo${ScreenName}(navOptions: NavOptions? = null) {
    this.navigate(${ScreenNameCapLowerCase}Route, navOptions)
}

fun NavGraphBuilder.${ScreenNameCapLowerCase}(
) {
    composable(
        route = ${ScreenNameCapLowerCase}Route,
    ) {
        ${ScreenName}Route()
    }
}
