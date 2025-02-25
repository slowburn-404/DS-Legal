package com.dslegal.convention

import com.dslegal.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KtorConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                "implementation"(libs.findLibrary("ktor-client-core").get())
                "implementation"(libs.findLibrary("ktor-client-okhttp").get())
                "implementation"(libs.findLibrary("ktor-content-negotiation").get())
                "implementation"(libs.findLibrary("ktor-kotlinx-serialization").get())
                "implementation"(libs.findLibrary("ktor-logging").get())

                // OkHttp Dependencies
                "implementation"(libs.findLibrary("okhttp").get())
                "implementation"(libs.findLibrary("okhttp-logging-interceptor").get())

            }
        }
    }

}