package com.loodos.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.viewModelScope
import com.loodos.common.base.BaseViewModel
import com.loodos.common.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by mertcantoptas on 10.03.2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeUiState>() {
    override fun createInitialState() = HomeUiState()

    init {
        viewModelScope.launch {
            setState { copy(isLoading = true) }
            setState {
                copy(
                    list = listOf(
                        ProductItem(0, "title", "amount"),
                        ProductItem(1, "Macbook", "çok pahalı"),
                        ProductItem(2, "title", "amount"),
                    ),
                    isLoading = false,
                )
            }
        }
    }

    fun onNavigateToDetailConsumed() {
        setState { copy(navigateToDetail = consumed()) }
    }

    fun onProductClick(item: ProductItem) {
        setState { copy(navigateToDetail = triggered(item.id)) }
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val title: String = "Home",
    val list: List<ProductItem> = listOf(),
    val navigateToDetail: StateEventWithContent<Int> = consumed(),
) : IViewState

@Stable
data class ProductItem(
    val id: Int,
    val title: String,
    val amount: String,
)
