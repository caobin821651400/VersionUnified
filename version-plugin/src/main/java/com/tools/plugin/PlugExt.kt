package com.tools.plugin

import ProjectVersion
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * App配置
 * @param ex ExtensionContainer
 */
fun configApp(ex: ExtensionContainer) {
    ex.configure<ApplicationExtension> {
        compileSdk = ProjectVersion.compileSdk
        defaultConfig {
            minSdk = ProjectVersion.minSdk
            targetSdk = ProjectVersion.targetSdk
            versionCode = ProjectVersion.versionCode
            versionName = ProjectVersion.versionName
            vectorDrawables.useSupportLibrary = true
            commonDefaultConfig(this)
        }
        //Application和library相同的配置
        unifiedConfiguration(this)
    }
}

/**
 * Library配置
 * @param ex ExtensionContainer
 */
fun configLibrary(ex: ExtensionContainer) {
    ex.configure<LibraryExtension> {
        compileSdk = ProjectVersion.compileSdk
        defaultConfig {
            minSdk = ProjectVersion.minSdk
            consumerProguardFiles("consumer-rules.pro")
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            commonDefaultConfig(this)
        }
        //Application和library相同的配置
        unifiedConfiguration(this)
    }
}

/**
 * 统一app和lib中的公共配置项
 * @param ex CommonExtension<*, *, *, *>
 */
fun unifiedConfiguration(ex: CommonExtension<*, *, *, *>) {
    ex.buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    ex.compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    ex.viewBinding {
        enable = true
    }
    ex.kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    ex.packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

/**
 * buildConfigField 可以在BuildConfig中定义一些静态常量，所有的module中都有
 * @param config DefaultConfig
 */
fun commonDefaultConfig(config: DefaultConfig) {
    //接口地址
    config.buildConfigField("String", "BASE_URL", "\"${ProjectVersion.url}\"")
    //添加参数到所以module的BuildConfig
    config.buildConfigField("boolean", "PARAM", "${ProjectVersion.param}")
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}