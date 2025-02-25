import org.gradle.internal.impldep.com.esotericsoftware.minlog.Log
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.dslegal.build_logic"

java{
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}



dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.tools.common)

}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = libs.plugins.dslegal.android.application.compose.get().pluginId
            implementationClass = "com.dslegal.convention.AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = libs.plugins.dslegal.android.library.compose.get().pluginId
            implementationClass = "com.dslegal.convention.AndroidComposeLibraryConventionPlugin"
        }

        register("androidApplication") {
            id = libs.plugins.dslegal.android.application.asProvider().get().pluginId
            implementationClass = "com.dslegal.convention.AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = libs.plugins.dslegal.android.library.asProvider().get().pluginId
            implementationClass = "com.dslegal.convention.AndroidLibraryConventionPlugin"
        }

        register("koin") {
            id = libs.plugins.dslegal.koin.get().pluginId
            implementationClass = "com.dslegal.convention.KoinConventionPlugin"
        }

        register("kotlinxSerialization") {
            id = libs.plugins.dslegal.kotlinx.serialization.get().pluginId
            implementationClass  = "com.dslegal.convention.KotlinxSerializationConventionPlugin"
        }

        register("ktor") {
            id = libs.plugins.dslegal.ktor.get().pluginId
            implementationClass = "com.dslegal.convention.KtorConventionPlugin"
        }
    }
}