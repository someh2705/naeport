plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.compose.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ktlint.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.naeport.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.naeport.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("compose") {
            id = libs.plugins.naeport.compose.get().pluginId
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("ktlint") {
            id = libs.plugins.naeport.static.analysis.get().pluginId
            implementationClass = "AndroidStaticAnalysisConventionPlugin"
        }
    }
}