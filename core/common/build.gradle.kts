@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.samplecomposeandroid.android.library)
    alias(libs.plugins.samplecomposeandroid.android.library.jacoco)
    alias(libs.plugins.samplecomposeandroid.android.hilt)
}

android {
    namespace = "com.loodos.samplecomposeandroid.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.compose.state.events)
}