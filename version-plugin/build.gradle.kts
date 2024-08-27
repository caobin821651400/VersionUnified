plugins {
    `kotlin-dsl`
}
gradlePlugin {
    //定义gradle插件
    plugins{
        register("AppGradlePlugin") {
            //app插件的id
            id = "example.app.plugin"
            //插件完整的包名类名
            implementationClass = "com.tools.plugin.AppBuildPlugin"
        }
        register("LibsBuildGradlePlugin") {
            //library插件的id
            id = "jx.libs"
            //插件完整的包名类名
            implementationClass = "com.tools.plugin.LibsBuildPlugin"
        }
        register("VersionBuildPlugin") {
            id = "version.libs"
            implementationClass = "com.tools.plugin.VersionBuildPlugin"
        }
    }
}

dependencies {
    //引入gradle
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
}

