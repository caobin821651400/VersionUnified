import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.kotlinCore() {
    "api"(Libraries.coreKtx)
    "api"(Libraries.kotlinxCoroutinesAndroid)
    "api"(Libraries.kotlinxCoroutinesCore)
}

fun DependencyHandlerScope.kotlinKtx() {
    "api"(Libraries.fragmentKtx)
    "api"(Libraries.activityKtx)
    "api"(Libraries.collectionKtx)
}

fun DependencyHandlerScope.androidCore() {
    "api"(Libraries.gson)
    "api"(Libraries.appcompat)
    "api"(Libraries.material)
    "api"(Libraries.annotation)
}

fun DependencyHandlerScope.lifecycle() {
    "api"(Libraries.lifecycle)
    "api"(Libraries.viewModelKtx)
    "api"(Libraries.liveDataKtx)
    "api"(Libraries.lifeCycleRunTimeKtx)
}


fun DependencyHandlerScope.store() {
    "api"(Libraries.mmkv)
}


fun DependencyHandlerScope.lifecycleImpl() {
    "implementation"(Libraries.lifecycle)
    "implementation"(Libraries.viewModelKtx)
    "implementation"(Libraries.liveDataKtx)
    "implementation"(Libraries.lifeCycleRunTimeKtx)
}

fun DependencyHandlerScope.commonView() {
    "api"(Libraries.recyclerview)
    "api"(Libraries.constraintlayout)
    "api"(Libraries.viewpager2)
}

fun DependencyHandlerScope.room() {
    "api"(Libraries.room)
    "api"(Libraries.roomKtx)
    "ksp"(Libraries.roomProcessor)
}

fun DependencyHandlerScope.network() {
    "api"(Libraries.okhttp)
    "api"(Libraries.okhttpLogging)
    "api"(Libraries.retrofit)
    "api"(Libraries.retrofitGsonConverter)
}

fun DependencyHandlerScope.router() {
    "ksp"(Libraries.routerApt)
    "implementation"(Libraries.router)
}

fun DependencyHandlerScope.exoPlayer() {
    "api"(Libraries.exoplayerCore)
    "api"(Libraries.exoplayerDash)
    "api"(Libraries.exoplayerHls)
//    "api"(Libraries.exoplayerRtsp)
//    "api"(Libraries.exoplayerRtmp)
}

fun DependencyHandlerScope.androidTest() {
    "testImplementation"(Libraries.junit)
    "androidTestImplementation"(Libraries.androidxJunit)
    "androidTestImplementation"(Libraries.espresso)
}