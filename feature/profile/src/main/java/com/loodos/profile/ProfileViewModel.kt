package com.loodos.profile

import com.loodos.common.base.BaseViewModel
import com.loodos.common.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel<ProfileViewState>() {

    override fun createInitialState(): ProfileViewState = ProfileViewState()
}

data class ProfileViewState(
    val loading: Boolean = false,
    val title: String = "Profile",
) : IViewState
