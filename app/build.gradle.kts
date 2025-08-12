plugins {
    alias(libs.plugins.naeport.android.application)
    alias(libs.plugins.naeport.static.analysis)
}

android {
    namespace = "com.someh.naeport"

    defaultConfig {
        applicationId = "com.someh.naeport"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}
