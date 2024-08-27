package com.tools.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

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
            configApp(extensions)
        }
    }
}




