package com.tools.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.plugins.PluginContainer

/**
 * @author: cb
 * @date: 2023/10/12
 * @desc: 统一多Module中Gradle的配置
 */
class VersionBuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        try {
            with(target) {

                val isApp = providers.gradleProperty("SEARCH_IS_APP").get() == "true"
                println("joker isApp=$isApp")

                if (isApp) {
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
                config(extensions, isApp)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun config(ex: ExtensionContainer, isApp: Boolean) {
        if (isApp) {
            configApp(ex)
        } else {
            configLibrary(ex)
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




