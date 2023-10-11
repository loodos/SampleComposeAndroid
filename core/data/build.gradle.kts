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
    implementation(libs.kotlinx.datetime)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.converter.moshi)
    implementation(libs.okhttp.logging.interceptor)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)
    implementation(projects.core.common)
    implementation(projects.core.designsystem)
}
