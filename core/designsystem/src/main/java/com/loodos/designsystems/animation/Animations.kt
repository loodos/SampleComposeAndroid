package com.loodos.designsystems.animation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically

const val AnimationDurationMs = 200
const val SlideOffsetY = 200

val slideIn = fadeIn() + slideInVertically(
    initialOffsetY = { SlideOffsetY },
    animationSpec = tween(AnimationDurationMs),
)

val slideOut = fadeOut() + slideOutVertically(
    targetOffsetY = { SlideOffsetY },
    animationSpec = tween(AnimationDurationMs),
)
