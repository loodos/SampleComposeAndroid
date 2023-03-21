package com.loodos.samplecomposeandroid.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.loodos.samplecomposeandroid.feature.home.navigation.homeNavigationRoute
import com.loodos.samplecomposeandroid.ui.components.MainAppScaffold

/**
 * Created by mertcantoptas on 10.03.2023
 */
@Composable
internal fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeUiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(homeUiState, modifier)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    MainAppScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = "Home Screen")
                },
            )
        },
    ) {
        Content(modifier = Modifier)
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is Loodos ", color = Color.Blue)
    }
}