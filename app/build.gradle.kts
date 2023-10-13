@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.samplecomposeandroid.android.application)
    alias(libs.plugins.samplecomposeandroid.android.application.compose)
    alias(libs.plugins.samplecomposeandroid.android.application.flavors)
    alias(libs.plugins.samplecomposeandroid.android.application.jacoco)
    alias(libs.plugins.samplecomposeandroid.android.hilt)
    id("jacoco")
    id("samplecomposeandroid.android.room")
    id("samplecomposeandroid.kotlinter")
}

android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        applicationId = "com.loodos.samplecomposeandroid"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = "debug"
        }
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    namespace = "com.loodos.samplecomposeandroid"
}
dependencies {
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.android.material)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.compose.ui.tooling)
    implementation(libs.square.moshi.kotlin)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.converter.moshi)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.okhttp.logging.interceptor)

    implementation(projects.feature.login)
    implementation(projects.feature.home)
    implementation(projects.feature.category)
    implementation(projects.feature.profile)
    implementation(projects.feature.productdetail)

    implementation(projects.core.common)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.core.domain)

    testImplementation(libs.junit4)

    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.compose.ui.test.junit)
    androidTestImplementation(libs.hilt.android.testing)
    implementation(libs.androidx.hilt.navigation.compose)


    debugImplementation(libs.compose.ui.test.manifest)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.square.leakcanary)
    implementation(libs.retrofit.converter.gson)

    kapt(libs.square.moshi.kotlin.codegen)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.compose.state.events)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.compose)


}