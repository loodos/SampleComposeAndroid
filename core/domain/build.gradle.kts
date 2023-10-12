@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("samplecomposeanroid.android.library")
    id("samplecomposeanroid.android.library.compose")
    kotlin("kapt")
}


android {
    namespace = "com.loodos.samplecomposeanroid.core.domain"
}

dependencies {
    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.runtime.livedata)

    implementation(projects.core.data)
    implementation(projects.core.common)

    kapt(libs.hilt.compiler)

}