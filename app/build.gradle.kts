plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "1.9.0"
    kotlin("kapt")
}

android {
    namespace = "com.itbenevides.caed"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.itbenevides.caed"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v270)
    implementation(libs.androidx.activity.compose.v182)
    implementation(platform(libs.androidx.compose.bom.v20240901))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.hilt.android)
    implementation(libs.androidx.benchmark.macro)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.testing)

    kapt(libs.hilt.android.compiler)
    kapt(libs.kotlinx.metadata.jvm)

    implementation(libs.coil)



    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(platform(libs.compose.bom.v20230800))
    androidTestImplementation(libs.ui.test.junit4)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.material3)

    api(project(":core"))

    testImplementation(libs.junit)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.core)
    testImplementation(libs.turbine)
    testImplementation(libs.mockito.kotlin)
    testImplementation(project(":core"))
    testImplementation(libs.androidx.core.testing)

}

kapt {
    correctErrorTypes = true
}