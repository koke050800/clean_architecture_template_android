plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.koke050800.clean_architecture_android_template"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.koke050800.clean_architecture_android_template"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    // Android libs
    implementation(libs.bundles.android.core)

    // Security
    implementation(libs.security.crypto)

    // Compose libs
    implementation(libs.bundles.compose)

    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Koin for DI
    implementation(libs.bundles.koin)

    // KTOR client
    implementation(libs.bundles.ktor)

    // Navigation 3
    implementation(libs.bundles.nav3.core)
    implementation(libs.bundles.nav3.optional)

    // Test libs
    testImplementation(libs.bundles.test.implementation)
    androidTestImplementation(libs.bundles.android.test.implementation)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.bundles.debug.implementation)
}