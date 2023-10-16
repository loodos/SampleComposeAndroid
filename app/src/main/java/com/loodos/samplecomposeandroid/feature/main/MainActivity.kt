package com.loodos.samplecomposeandroid.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.metrics.performance.JankStats
import com.loodos.data.util.NetworkMonitor
import com.loodos.designsystems.theme.SampleComposeAndroidTheme
import com.loodos.samplecomposeandroid.feature.appstate.MainApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Inject
    lateinit var lazyStats: dagger.Lazy<JankStats>

    companion object {
        const val splashFadeDurationMillis = 1000L
        const val splashIconRotation = 360f
    }

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach {
                        uiState = it
                    }
                    .collect()
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }

        // If the splash screen is still visible, set the content view
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S_V2) {
            splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
                // Get logo and start a fade out animation
                splashScreenViewProvider.iconView
                    .animate()
                    .rotation(splashIconRotation)
                    .setDuration(splashFadeDurationMillis)
                    .alpha(0f)
                    .withEndAction {
                        // After the fade out, remove the
                        // splash and set content view
                        splashScreenViewProvider.remove()
                        setContent()
                    }.start()
            }
        } else {
            setContent()
        }
    }

    private fun setContent() {
        setContent {
            SampleComposeAndroidTheme {
                MainApp(networkMonitor = networkMonitor)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lazyStats.get().isTrackingEnabled = true
    }

    override fun onPause() {
        super.onPause()
        lazyStats.get().isTrackingEnabled = false
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    com.loodos.designsystems.theme.SampleComposeAndroidTheme {
        Greeting("Android")
    }
}
