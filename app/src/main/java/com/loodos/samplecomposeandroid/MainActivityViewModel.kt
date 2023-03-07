package com.loodos.samplecomposeandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by mertcantoptas on 07.03.2023
 */

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = mainUiState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainActivityUiState.Loading
        )
}

private fun mainUiState(): Flow<MainActivityUiState> {
    return flow {
        emit(MainActivityUiState.Loading)
        delay(1000)
        emit(MainActivityUiState.Success)
    }
}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    object Success : MainActivityUiState
}
