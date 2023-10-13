@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.samplecomposeandroid.android.feature)
    alias(libs.plugins.samplecomposeandroid.android.library.compose)
    alias(libs.plugins.samplecomposeandroid.android.library.jacoco)
}

android {
    namespace = "com.loodos.samplecomposeandroid.feature.login"
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.activity.compose)
}
