package com.loodos.productdetail

import androidx.lifecycle.SavedStateHandle
import com.loodos.common.base.BaseViewModel
import com.loodos.common.base.IViewState
import com.loodos.productdetail.navigation.idArg
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
