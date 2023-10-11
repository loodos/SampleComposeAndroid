import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class FirebasePerfConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.findPlugin("com.google.firebase.firebase-perf").apply {
                version = libs.findVersion("firebase-pref").get().toString()
            }
        }
    }
}
