package com.loodos.samplecomposeandroid.feature.productdetail

import androidx.lifecycle.SavedStateHandle
import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<ProductDetailViewState>() {

    override fun createInitialState(): ProductDetailViewState = ProductDetailViewState()

    init {
        val id = savedStateHandle.get<Int>(idArg)
        setState { copy(id = id) }
    }
}

data class ProductDetailViewState(
    val id: Int? = null,
    val loading: Boolean = false,
) : IViewState
