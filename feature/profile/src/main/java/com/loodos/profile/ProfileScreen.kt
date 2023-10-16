package com.loodos.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileRoute(
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    ProfileScreen(
        uiState = uiState,
    )
}

@Composable
fun ProfileScreen(
    uiState: ProfileViewState,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = uiState.title)
    }
}
