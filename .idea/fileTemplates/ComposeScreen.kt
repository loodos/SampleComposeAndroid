#set($ScreenNameLowerCase = $ScreenName.toLowerCase())
package ${PACKAGE_NAME}

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ${ScreenName}Route(
    viewModel: ${ScreenName}ViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    
    ${ScreenName}Screen(
        uiState = uiState,
    )
}

@Composable
fun ${ScreenName}Screen(
    uiState: ${ScreenName}ViewState,
    modifier: Modifier = Modifier,
) {

}
