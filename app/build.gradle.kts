plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.flapsense"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.flapsense"
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
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.activity:activity-compose:1.8.2")
    implementation ("androidx.compose.ui:ui:$1.2.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:$1.2.1")
    implementation ("androidx.compose.runtime:runtime-livedata:$1.2.1")
    implementation ("androidx.compose.material3:material3:1.3.0-alpha03")
    implementation ("com.google.android.gms:play-services-wearable:18.1.0")
    implementation ("androidx.core:core-ktx:+")
    implementation ("androidx.test:rules:1.5.0")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.google.firebase:firebase-messaging:23.4.1")
    implementation("com.google.firebase:firebase-inappmessaging-display:20.4.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    debugImplementation ("androidx.compose.ui:ui-tooling:$1.2.1")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$1.2.1")
    val mockkVersion = "1.13.10"
    testImplementation("io.mockk:mockk:${mockkVersion}")
    implementation ("com.google.android.gms:play-services-location:21.2.0")

}