package com.tools.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer

/**
 * @author: cb
 * @date: 2023/10/12
 * @desc: 统一多Module中Gradle的配置
 */
class LibsBuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        try {
            with(target) {

                var isModuleApp = false
                try {
                    //需要注意这里key用了module的名称+(_app)，例如：proj_search_app
                    // 在gradle.properties定义
                    val key = "${project.name}_app"
                    isModuleApp = providers.gradleProperty(key).get() == "true"
                } catch (e: Exception) {
                }

                println("isApp=$isModuleApp")

                //判断是否需要app单独运行
                if (isModuleApp) {
                    plugins.apply {
                        apply("com.android.application")
                        addCommonPluginContainer(this)
                    }
                } else {
                    plugins.apply {
                        apply("com.android.library")
                        addCommonPluginContainer(this)
                    }
                }

                //根据不同配置，走App还是Library
                if (isModuleApp) {
                    configModuleApp(extensions, "${project.name}.application.id")
                } else {
                    configLibrary(extensions)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * 添加公共的插件
     * @param pluginContainer PluginContainer
     */
    private fun addCommonPluginContainer(pluginContainer: PluginContainer) {
        pluginContainer.apply("kotlin-android")
        pluginContainer.apply("kotlin-parcelize")
    }
}




