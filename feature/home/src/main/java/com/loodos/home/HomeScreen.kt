@file:OptIn(ExperimentalMaterial3Api::class)

package com.loodos.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.loodos.samplecomposeandroid.feature.home.R
import com.loodos.ui.TrackScrollJank
import de.palm.composestateevents.EventEffect

/**
 * Created by mertcantoptas on 10.03.2023
 */
@Composable
internal fun HomeScreenRoute(
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState by viewModel.uiState.collectAsStateWithLifecycle()

    EventEffect(
        event = homeUiState.navigateToDetail,
        onConsumed = viewModel::onNavigateToDetailConsumed,
        action = navigateToDetail,
    )

    HomeScreen(
        homeUiState = homeUiState,
        modifier = modifier,
        onProductClick = viewModel::onProductClick,
    )
}

@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    onProductClick: (ProductItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    com.loodos.designsystems.component.MainAppScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = homeUiState.title)
                },
            )
        },
    ) { padding ->
        Content(
            modifier = Modifier.padding(padding),
            homeUiState = homeUiState,
            onProductClick = onProductClick,
        )
    }
}

@Composable
fun Content(
    homeUiState: HomeUiState,
    onProductClick: (ProductItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollableState = rememberLazyListState()
    TrackScrollJank(scrollableState = scrollableState, stateName = "home:LazyList")

    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn(
            state = scrollableState,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            itemsIndexed(homeUiState.list) { index, item ->
                ProductListItem(
                    productItem = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {
                        onProductClick(item)
                    },
                )
//                if (index < productList.lastIndex) {
//                    Spacer(modifier = Modifier.height(8.dp))
//                }
            }
            item {
                if (homeUiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ProductListItem(
    productItem: ProductItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                RoundedCornerShape(16.dp),
            )
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_compose),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = productItem.title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = productItem.amount, style = MaterialTheme.typography.bodyMedium)
    }
}
