package com.dslegal.convention

import com.android.build.api.dsl.ApplicationExtension
import com.dslegal.convention.helpers.configureKotlinAndroid
import com.dslegal.convention.utils.AndroidSdk
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.application")
            apply(plugin = "org.jetbrains.kotlin.android")


            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidSdk.TARGET_SDK
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
            }

        }

    }

}