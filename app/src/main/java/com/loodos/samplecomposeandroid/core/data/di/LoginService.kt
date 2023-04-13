package com.loodos.samplecomposeandroid.core.data.di

import com.loodos.samplecomposeandroid.core.data.remote.api.AuthenticationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

/**
 * Created by mertcantoptas on 13.04.2023
 */

@Module
@InstallIn(ViewModelComponent::class)
class LoginModule {
    @Provides
    fun provideLoginService(retrofit: Retrofit): AuthenticationService {
        return retrofit.create(AuthenticationService::class.java)
    }
}