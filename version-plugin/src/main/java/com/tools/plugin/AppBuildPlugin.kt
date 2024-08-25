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
class AppBuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            //配置app plugin,可以统一添加一些插件
            plugins.run {
                apply("com.android.application")
                apply("kotlin-android")
                apply("kotlin-parcelize")
            }
            //配置android{},注意这里是ApplicationExtension
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
                //签名信息
                signingConfigs {
                    create("release") {
                        storeFile = file("../app/keystore.jks")
                        storePassword = "123456"
                        keyAlias = "key0"
                        keyPassword = "123456"
                    }
                }
                //Application和library相同的配置
                unifiedConfiguration(this)
            }
        }
    }
}




