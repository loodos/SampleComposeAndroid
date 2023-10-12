package com.loodos.data.di

import com.loodos.data.util.ConnectivityManagerNetworkMonitor
import com.loodos.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by mertcantoptas on 10.03.2023
 */
@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}
