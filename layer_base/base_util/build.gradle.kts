plugins {
    id("jx.libs")
}

android {
    namespace = "com.example.util"

    defaultConfig {
    }
}

dependencies {
    kotlinCore()
    lifecycle()
    kotlinKtx()
    commonView()
    androidTest()
}