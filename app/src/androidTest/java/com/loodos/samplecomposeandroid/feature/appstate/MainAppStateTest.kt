package com.loodos.samplecomposeandroid.feature.appstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import com.loodos.samplecomposeandroid.util.TestNetworkMonitor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Created by mertcantoptas on 21.03.2023
 */

@OptIn(ExperimentalCoroutinesApi::class)
class MainAppStateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val networkMonitor = TestNetworkMonitor()

    // Subject under test.
    private lateinit var state: MainAppState

    @Test
    fun mainAppState_currentDestination() = runTest {
        var currentDestination: String? = null

        composeTestRule.setContent {
            val navController = rememberTestNavController()
            state = remember(navController) {
                MainAppState(
                    navController = navController,
                    networkMonitor = networkMonitor,
                    coroutineScope = backgroundScope,
                )
            }

            // Update currentDestination when the navController changes.
            currentDestination = navController.currentDestination?.route

            // Navigate to destination b once
            LaunchedEffect(Unit) {
                navController.setCurrentDestination("b")
                currentDestination = navController.currentDestination?.route
            }
        }

        assertEquals("b", currentDestination)
    }

    @Test
    fun mainAppState_stateIsOfflineWhenNetworkMonitorIsOffline() =
        runTest(UnconfinedTestDispatcher()) {
            composeTestRule.setContent {
                state = MainAppState(
                    navController = NavHostController(LocalContext.current),
                    networkMonitor = networkMonitor,
                    coroutineScope = backgroundScope,
                )
            }
            backgroundScope.launch { state.isOffline.collect() }
            networkMonitor.setConnected(false)
            assertEquals(true, state.isOffline.value)
        }

    @Test
    fun mainAppState_stateIsOnlineWhenNetworkMonitorIsOnline() =
        runTest(UnconfinedTestDispatcher()) {
            composeTestRule.setContent {
                state = MainAppState(
                    navController = NavHostController(LocalContext.current),
                    networkMonitor = networkMonitor,
                    coroutineScope = backgroundScope,
                )
            }
            backgroundScope.launch { state.isOffline.collect() }
            networkMonitor.setConnected(true)
            assertEquals(false, state.isOffline.value)
        }
}

@Composable
private fun rememberTestNavController(): TestNavHostController {
    val context = LocalContext.current
    val navController = remember {
        TestNavHostController(context).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
            graph = createGraph(startDestination = "a") {
                composable("a") { }
                composable("b") { }
                composable("c") { }
            }
        }
    }
    return navController
}
