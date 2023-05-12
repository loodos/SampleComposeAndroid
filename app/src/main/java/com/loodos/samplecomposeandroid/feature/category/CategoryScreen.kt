package com.loodos.samplecomposeandroid.feature.category

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.loodos.samplecomposeandroid.core.data.model.category.CardItem
import com.loodos.samplecomposeandroid.feature.home.Content
import com.loodos.samplecomposeandroid.feature.home.HomeUiState
import com.loodos.samplecomposeandroid.feature.home.HomeViewModel
import com.loodos.samplecomposeandroid.feature.home.navigation.homeNavigationRoute
import com.loodos.samplecomposeandroid.ui.components.MainAppScaffold
import com.loodos.samplecomposeandroid.ui.theme.CardBlue


/**
 * Created by Murat Korkmazoğlu on 11.05.2023.
 * Loodos
 * murat.korkmazoglu@loodos.com
 */
@Composable
internal fun CategoryScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categoryUiState by viewModel.uiState.collectAsStateWithLifecycle()

    CategoryScreen(categoryUiState, modifier)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    categoryUiState: CategoryUiState,
    modifier: Modifier = Modifier,
) {
    MainAppScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = "Category Screen")
                },
            )
        },
    ) {
        CategoryContent(modifier = Modifier.padding(it))
    }
}

@Composable
fun CategoryContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Center
    ) {
        ImageCardSection(
            listOf(
                CardItem(
                    "Electronics",
                    com.loodos.samplecomposeandroid.R.drawable.card1
                ),
                CardItem(
                    "Jewelry",
                    com.loodos.samplecomposeandroid.R.drawable.icon_compose
                ),
                CardItem(
                    "Men’s",
                    com.loodos.samplecomposeandroid.R.drawable.icon_compose
                ),
                CardItem(
                    "Women’s",
                    com.loodos.samplecomposeandroid.R.drawable.icon_compose
                )
            )
        )
    }
}

@Composable
fun ImageCardSection(
    cardList: List<CardItem>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cardList) { item ->
            ImageCard(cardItem = item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCard(
    cardItem: CardItem,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .shadow(5.dp, shape = RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = CardBlue),
        onClick = {

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .aspectRatio(1f),
                painter = painterResource(id = cardItem.iconId),
                contentDescription = cardItem.title,
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = cardItem.title,
                style = TextStyle(color = Color.Black, fontSize = 16.sp)
            )
        }
    }
}