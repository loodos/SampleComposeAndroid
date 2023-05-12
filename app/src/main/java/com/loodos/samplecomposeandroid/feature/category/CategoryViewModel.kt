package com.loodos.samplecomposeandroid.feature.category

import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor() : BaseViewModel<CategoryUiState>() {
    override fun createInitialState() = CategoryUiState()
}

data class CategoryUiState(
    val isLoading: Boolean = false,
) : IViewState