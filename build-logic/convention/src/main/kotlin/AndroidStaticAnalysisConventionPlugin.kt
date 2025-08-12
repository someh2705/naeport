import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class AndroidStaticAnalysisConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jlleitschuh.gradle.ktlint")

            extensions.configure<KtlintExtension> {
                android.set(true)
                ignoreFailures.set(true)
                additionalEditorconfig.set(
                    mapOf(
                        "max_line_length" to "120",
                        "ktlint_function_naming_ignore_when_annotated_with" to "Composable"
                    )
                )
                reporters {
                    reporter(ReporterType.CHECKSTYLE)
                }
            }

            tasks.getByPath("preBuild").dependsOn("ktlintFormat")
        }
    }
}