package com.loodos.samplecomposeandroid.feature.home

import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by mertcantoptas on 10.03.2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeUiState>() {
    override fun createInitialState() = HomeUiState()
}

data class HomeUiState(
    val isLoading: Boolean = false,
) : IViewState