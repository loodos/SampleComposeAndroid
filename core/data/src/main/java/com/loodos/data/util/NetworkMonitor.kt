package com.loodos.data.util

import kotlinx.coroutines.flow.Flow

/**
 * Created by mertcantoptas on 10.03.2023
 */

interface NetworkMonitor {
    val isOnline: Flow<Boolean>
}
