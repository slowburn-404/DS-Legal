package com.dslegal.convention.helpers

import com.android.build.api.dsl.CommonExtension
import com.dslegal.convention.utils.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {

    commonExtension.apply {
        buildFeatures {
            compose = true
        }


        configureKotlinAndroid(commonExtension)

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()

            "implementation"(platform(bom))
            "androidTestImplementation"(platform(bom))
            "implementation"(libs.findLibrary("androidx-ui-tooling-preview").get())
            "debugImplementation"(libs.findLibrary("androidx-ui-tooling").get())

        }
    }

}