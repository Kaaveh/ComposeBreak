plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlinAndroid)
}

android {
    namespace = "ir.kaaveh.designesystem"
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
    val composeBom = platform(libs.androidx.compose.bom)
    api(composeBom)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.uiGraphics)
    api(libs.androidx.compose.uiToolingPreview)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.materialIcon)
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
    debugApi(libs.androidx.compose.uiTooling)
    debugApi(libs.androidx.compose.uiTestManifest)
}