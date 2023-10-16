package com.loodos.category

import com.loodos.common.base.BaseViewModel
import com.loodos.common.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor() : BaseViewModel<CategoryViewState>() {

    override fun createInitialState(): CategoryViewState = CategoryViewState()
}

data class CategoryViewState(
    val loading: Boolean = false,
    val title: String = "Category",
) : IViewState
