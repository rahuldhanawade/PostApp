plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.duadm_post"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.duadm_post"
        minSdk = 24
        targetSdk = 35
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
        debug {
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

    dataBinding {
        enable = true
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.gson)
    implementation (libs.retrofit)
    implementation (libs.converterGson)
    implementation (libs.httpLoggingInterceptor)

    // Hilt for Dependency Injection
    implementation (libs.hilt)
    kapt(libs.hilt.compiler) // Add the Hilt compiler for annotation processing

    // Room for local database
    implementation (libs.room)
    kapt (libs.roomCompiler)

    // Glide for image loading
    implementation (libs.glide)

    // Coroutines for background work
    implementation (libs.coroutinesCore)

    // LiveData and ViewModel from Android Lifecycle components
    implementation (libs.lifecycleLiveData)
    implementation (libs.lifecycleViewModel)

    // RecyclerView for lists
    implementation (libs.recyclerview)
}