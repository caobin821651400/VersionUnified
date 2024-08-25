plugins {
//    id("com.android.application") apply true
//    id("com.android.library") apply false
    id("jx.libs")
    id("com.google.devtools.ksp")
    println("caobin 1")
}

//val isApp = providers.gradleProperty("SEARCH_IS_APP").get() == "true"
//
//if (isApp) {
//    println("caobin 2")
//    apply(plugin = "com.android.application")
//} else {
//    println("caobin 3")
//    apply(plugin = "com.android.library")
//}

//afterEvaluate {
    android {
        println("caobin 3")
        namespace = "com.example.proj.search"

        defaultConfig {
        }

    }

    dependencies {
        router()
        implementation(project(":common_core"))
    }

//}
