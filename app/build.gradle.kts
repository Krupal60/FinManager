plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    kotlin("plugin.serialization") version "2.0.0"
    alias(libs.plugins.compose.compiler)
}


android {
    namespace = "com.krupal.finmanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.krupal.finmanager"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".debug"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "35.0.0"
    ndkVersion = "25.2.9519653"
}
composeCompiler {
    enableStrongSkippingMode = true

    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // navigation
    implementation(libs.androidx.navigation.compose)

    // lifecycle compose
    implementation(libs.androidx.lifecycle.runtime.compose)


    // navigation suite alpha

  //  implementation(libs.androidx.material3.adaptive.navigation.suite.android)

    implementation(libs.androidx.material3.adaptive.navigation.suite)

    implementation(libs.androidx.adaptive.android)


    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.ui.text.google.fonts)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Material Icon Extension
    implementation(libs.androidx.material.icons.extended)

    //realm db
    implementation(libs.library.base)

    // splashScreen
    implementation(libs.androidx.core.splashscreen)

    //serialization
    implementation(libs.kotlinx.serialization.json)

    //datastore
    implementation(libs.androidx.datastore.preferences)

    //sdp ssp
    implementation(libs.jetpack.sdp.ssp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}