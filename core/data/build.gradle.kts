plugins {
    id("samplecomposeanroid.android.library")
    id("samplecomposeanroid.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.loodos.samplecomposeanroid.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

}
