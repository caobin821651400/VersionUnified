plugins {
    id("jx.libs")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.proj.home"

    defaultConfig {
    }
}

dependencies {
    router()
    implementation(project(":common_core"))
}