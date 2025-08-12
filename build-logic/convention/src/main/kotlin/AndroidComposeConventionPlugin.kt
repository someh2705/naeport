import com.android.build.api.dsl.ApplicationExtension
import com.someh.naeport.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")

            extensions.configure<ApplicationExtension> {
                buildFeatures {
                    compose = true
                }
            }

            dependencies {
                "implementation"(platform(libs.findLibrary("androidx-compose-bom").get()))
                "implementation"(libs.findLibrary("androidx-activity-compose").get())
                "implementation"(libs.findBundle("androidx-compose").get())
                "androidTestImplementation"(libs.findBundle("androidx-compose-android-test").get())
                "implementation"(libs.findBundle("androidx-compose-debug").get())
            }
        }
    }
}