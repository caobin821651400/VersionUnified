plugins {
    `kotlin-dsl`
}
gradlePlugin {
    plugins{
        register("TvAppGradlePlugin") {
            //插件的id
            id = "example.app.plugin"
            implementationClass = "com.tools.plugin.BuildPlugin"
        }
        register("LibsBuildGradlePlugin") {
            id = "jx.libs"
            implementationClass = "com.tools.plugin.LibsBuildPlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
}

