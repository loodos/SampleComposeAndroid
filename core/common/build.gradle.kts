plugins {
    id("samplecomposeanroid.android.library")
    id("samplecomposeanroid.android.hilt")
}

android {
    namespace = "com.loodos.samplecomposeanroid.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}