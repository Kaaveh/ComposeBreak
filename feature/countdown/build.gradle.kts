plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlinAndroid)
    alias(libs.plugins.android.daggerHilt)
    kotlin("kapt")
}

android {
    namespace = "ir.kaaveh.countdown"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    projects.library.apply {
        implementation(designsystem)
        implementation(extFunctions)
    }

    implementation(libs.androidx.lifecycleViewmodelKtx)
    implementation(libs.dagger.hiltAndroid)
    kapt(libs.dagger.hiltAndroidCompiler)
    implementation(libs.androidx.hiltNavigationCompose)
}

kapt {
    correctErrorTypes = true
}