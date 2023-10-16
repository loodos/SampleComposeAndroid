package com.loodos.productdetail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

private const val dragFactor = 0.2f

@Composable
fun ProductDetailRoute(
    viewModel: ProductDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    ProductDetailScreen(
        uiState = uiState,
    )
}

@Composable
fun ProductDetailScreen(
    uiState: ProductDetailViewState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var offset by remember { mutableStateOf(Offset.Zero) }
        val rotateX by animateFloatAsState(targetValue = offset.y, label = "")
        val rotateY by animateFloatAsState(targetValue = offset.x, label = "")
        Card(
            modifier = Modifier
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragEnd = {
                            offset = Offset.Zero
                        },
                    ) { change, dragAmount ->
                        change.consume()
                        offset = offset
                            .plus(dragAmount)
                            .times(dragFactor)
                    }
                }
                .graphicsLayer {
                    rotationX = rotateX
                    rotationY = rotateY
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
            ),
        ) {
            Text(text = "Passed arg: ${uiState.id}")
        }
    }
}
