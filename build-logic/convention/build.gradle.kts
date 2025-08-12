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
        register("ktlint") {
            id = libs.plugins.naeport.static.analysis.get().pluginId
            implementationClass = "AndroidStaticAnalysisConventionPlugin"
        }
    }
}