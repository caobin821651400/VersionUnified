package com.tools.plugin

import ProjectVersion
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * @author: cb
 * @date: 2023/10/12
 * @desc: 统一多Module中Gradle的配置
 */
class BuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            //配置plugin
            plugins.run {
                apply("com.android.application")
                apply("kotlin-android")
                apply("kotlin-parcelize")
            }
            //配置android
            extensions.configure<ApplicationExtension> {
                compileSdk = ProjectVersion.compileSdk
                defaultConfig {
                    minSdk = ProjectVersion.minSdk
                    targetSdk = ProjectVersion.targetSdk
                    versionCode = ProjectVersion.versionCode
                    versionName = ProjectVersion.versionName
                    vectorDrawables.useSupportLibrary = true
                    commonDefaultConfig(this)
                }
                lint { baseline = file("lint-baseline.xml") }

                signingConfigs {
                    create("release") {
                        storeFile = file("../appTv/utv.keystore")
                        storePassword = "utv123321"
                        keyAlias = "utv"
                        keyPassword = "utv123321"
                    }
                }
                unifiedConfiguration(this)
            }
        }
    }
}




