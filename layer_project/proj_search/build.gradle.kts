plugins {
    id("version.libs")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.proj.search"

    defaultConfig {
    }

}

dependencies {
    router()
    implementation(project(":common_core"))
}
