package com.tools.plugin

import ProjectVersion
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * @author: cb
 * @date: 2023/10/12
 * @desc: 统一多Module中Gradle的配置
 */
class LibsBuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            //配置plugin
            plugins.run {
                apply("com.android.library")
                apply("kotlin-android")
                apply("kotlin-parcelize")
            }
            //配置android
            extensions.configure<LibraryExtension> {
                compileSdk = ProjectVersion.compileSdk
                defaultConfig {
                    minSdk = ProjectVersion.minSdk
                    consumerProguardFiles("consumer-rules.pro")
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    commonDefaultConfig(this)
                }
                unifiedConfiguration(this)
            }
        }
    }
}




