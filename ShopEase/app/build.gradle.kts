    plugins {
        alias(libs.plugins.android.application)
    }

    android {
        namespace = "mx.com.cst.mobile.shopease"
        compileSdk = 34

        defaultConfig {
            applicationId = "mx.com.cst.mobile.shopease"
            minSdk = 26
            targetSdk = 34
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
    }

    dependencies {

        implementation(libs.appcompat)
        implementation(libs.material)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
        // Para las imagenes
        // implementation 'com.squareup.picasso:picasso:2.71828'
        implementation(libs.picasso)
        // Retrofit para hacer la solicitud HTTP
        // implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        implementation(libs.retrofit)
        // Para tratar los JSON
        // implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
        implementation(libs.converter.gson)


    }

