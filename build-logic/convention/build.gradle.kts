import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.loodos.samplecomposeanroid.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "samplecomposeanroid.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "samplecomposeanroid.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "samplecomposeanroid.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "samplecomposeanroid.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "samplecomposeanroid.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "samplecomposeanroid.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "samplecomposeanroid.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }

        register("androidTest") {
            id = "samplecomposeanroid.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidHilt") {
            id = "samplecomposeanroid.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "samplecomposeanroid.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("firebase-perf") {
            id = "samplecomposeanroid.firebase-perf"
            implementationClass = "FirebasePerfConventionPlugin"
        }
        register("androidFlavors") {
            id = "samplecomposeanroid.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }

        register("kotlinter") {
            id = "samplecomposeanroid.kotlinter"
            implementationClass = "KotlinLinterPlugin"
        }
    }
}
