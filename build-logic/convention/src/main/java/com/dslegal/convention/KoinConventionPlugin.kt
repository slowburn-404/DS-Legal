package com.dslegal.convention

import com.dslegal.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KoinConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                "implementation"(platform(libs.findLibrary("koin-bom").get()))
                "implementation"(libs.findLibrary("koin-core").get())
                "implementation"(libs.findLibrary("koin-android").get())
                "implementation"(libs.findLibrary("koin-androidx-compose").get())
                "implementation"(libs.findLibrary("koin-androidx-compose-navigation").get())


                "testImplementation"(libs.findLibrary("koin-test").get())
                "testImplementation"(libs.findLibrary("koin-test-junit4").get())
            }
        }
    }


}