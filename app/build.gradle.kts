plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.loodos.samplecomposeandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.loodos.samplecomposeandroid"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    lint {
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)

    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)

    implementation(libs.androidx.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)

    //Splash
    implementation(libs.androidx.core.splashscreen)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // lint
    lintChecks(libs.lint.checks)
    // compose state events
    implementation(libs.compose.state.events)

    testImplementation(libs.turbine)
    testImplementation(libs.truth)

    // To use the androidx.test.core APIs
    androidTestImplementation(libs.androidx.test.core)
    // Kotlin extensions for androidx.test.core
    androidTestImplementation(libs.androidx.test.ktx)

    // To use the JUnit Extension APIs
    testImplementation(libs.androidx.test.ext)
    // Kotlin extensions for androidx.test.ext.junit
    testImplementation(libs.androidx.test.ext.ktx)

    // To use the Truth Extension APIs
    testImplementation(libs.truth.ext)
    testImplementation(libs.jetbrains.kotlin.test)
    implementation(libs.androidx.navigation.testing)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test)

}