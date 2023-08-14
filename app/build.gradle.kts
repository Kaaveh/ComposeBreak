plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlinAndroid)
    alias(libs.plugins.android.daggerHilt)
    kotlin("kapt")
}

android {
    namespace = "ir.kaaveh.composebreak"
    compileSdk = 33

    defaultConfig {
        applicationId = "ir.kaaveh.composebreak"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    projects.apply {
        implementation(projects.library.designsystem)
        implementation(projects.feature.countdown)
    }

    implementation(libs.androidx.ktx)
    implementation(libs.androidx.lifecycleRuntimelKtx)
    implementation(libs.androidx.activityCompose)

    implementation(libs.dagger.hiltAndroid)
    kapt(libs.dagger.hiltAndroidCompiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
}

kapt {
    correctErrorTypes = true
}