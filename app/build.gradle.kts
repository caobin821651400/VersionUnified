plugins {
    id("example.app.plugin")
    id("com.google.devtools.ksp")
    id("therouter")
}

android {
    namespace = ProjectVersion.applicationId

    defaultConfig {
        applicationId = ProjectVersion.applicationId
        ndk {
            abiFilters.add("armeabi-v7a")
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    flavorDimensions += listOf("version")

    //打包名称
    applicationVariants.all {
        val variant = this
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val builtType = variant.buildType.name
                if ("debug" == builtType) {
                    return@forEach
                }
                val versionName = variant.versionCode
                output.outputFileName =
                    "project_${versionName}_${ProjectVersion.getCurrDate()}.apk"
            }
    }
}

dependencies {
    router()
    implementation(project(":common_core"))
    implementation(project(":proj_home"))
    implementation(project(":proj_search"))
}