package ${PACKAGE_NAME}

import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${ScreenName}ViewModel @Inject constructor(
) : BaseViewModel<${ScreenName}ViewState>() {
    
    override fun createInitialState(): ${ScreenName}ViewState = ${ScreenName}ViewState()
    
}

data class ${ScreenName}ViewState(
    val loading: Boolean = false,
): IViewState
