package com.dslegal.convention

import com.android.build.gradle.LibraryExtension
import com.dslegal.convention.helpers.configureAndroidCompose
import com.dslegal.convention.helpers.configureKotlinAndroid
import com.dslegal.convention.utils.AndroidSdk
import com.dslegal.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidSdk.TARGET_SDK
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                testOptions.animationsDisabled = true

            }

            dependencies {
                "androidTestImplementation"(libs.findLibrary("androidx.junit").get())
                "testImplementation"(libs.findLibrary("junit").get())
            }
        }
    }
}