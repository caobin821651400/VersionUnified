plugins {
    id("jx.libs")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.common.core"

    defaultConfig {
    }
}

dependencies {
    router()
    api(project(":base_util"))
}