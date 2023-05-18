package com.loodos.samplecomposeandroid.feature.profile

import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel<ProfileViewState>() {

    override fun createInitialState(): ProfileViewState = ProfileViewState()
}

data class ProfileViewState(
    val loading: Boolean = false,
) : IViewState
