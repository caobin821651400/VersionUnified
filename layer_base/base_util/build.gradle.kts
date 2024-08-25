plugins {
    //引入我们自己定义的Library插件
    id("jx.libs")
}

android {
    namespace = "com.example.util"

    defaultConfig {
    }
}

dependencies {
    //对应Extension.kt
    kotlinCore()
    lifecycle()
    kotlinKtx()
    commonView()
    androidTest()
    //当然也可以引入单个库
    api(Libraries.viewpager2)
}