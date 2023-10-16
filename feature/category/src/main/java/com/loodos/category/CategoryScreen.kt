package com.loodos.category

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CategoryRoute(
    viewModel: CategoryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    CategoryScreen(
        uiState = uiState,
    )
}

@Composable
fun CategoryScreen(
    uiState: CategoryViewState,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = uiState.title)
    }
}
