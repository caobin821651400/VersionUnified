plugins {
    id("jx.libs")
}

android {
    namespace = "com.example.extends.ijk"

    defaultConfig {
    }
}

dependencies {
    implementation(project(":common_core"))
//    api("ijk的库")
}