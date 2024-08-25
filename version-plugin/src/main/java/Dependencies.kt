object Versions {
    const val kotlin = "1.8.0"
    const val lifecycle = "2.6.1"
    const val junit = "4.13.2"
    const val androidxJunit = "1.1.3"
    const val espresso = "3.4.0"
    const val kotlinxCoroutinesVersion = "1.6.4"
    const val roomVersion = "2.5.0"
    const val okhttpVersion = "3.12.0"
    const val routerVersion = "1.2.2"
    const val exoVersion = "1.1.1"
}

object Libraries {
    //Kotlin
    const val coreKtx = "androidx.core:core-ktx:${Versions.kotlin}"
    const val kotlinxCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutinesVersion}"
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutinesVersion}"

    //Kotlin Ktx
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.6.0"
    const val activityKtx = "androidx.activity:activity-ktx:1.6.0"
    const val collectionKtx = "androidx.collection:collection-ktx:1.3.0"

    //AndroidX
    const val appcompat = "androidx.appcompat:appcompat:1.5.0"
    const val material = "com.google.android.material:material:1.9.0"
    const val annotation = "androidx.annotation:annotation:1.7.0"

    //lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifeCycleRunTimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //测试库
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    //View
    const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"

    //room
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomProcessor = "androidx.room:room-compiler:${Versions.roomVersion}"

    //网络
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:2.6.1"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:2.3.0"

    //Glide
    const val glide = "com.github.bumptech.glide:glide:4.16.0"
    const val glideOkhttp = "com.github.bumptech.glide:okhttp3-integration:4.16.0"

    //路由
    const val router = "cn.therouter:router:${Versions.routerVersion}"
    const val routerApt = "cn.therouter:apt:${Versions.routerVersion}"

    //exo
    const val exoplayerCore = "androidx.media3:media3-exoplayer:${Versions.exoVersion}"
    const val exoplayerDash = "androidx.media3:media3-exoplayer-dash:${Versions.exoVersion}"
    const val exoplayerHls = "androidx.media3:media3-exoplayer-hls:${Versions.exoVersion}"
    const val exoplayerRtsp = "androidx.media3:media3-exoplayer-rtsp:${Versions.exoVersion}"
    const val exoplayerRtmp = "androidx.media3:media3-exoplayer-rtmp:${Versions.exoVersion}"

    //其他
    const val gson = "com.google.code.gson:gson:2.9.1"

    //动画
    const val lottie = "com.airbnb.android:lottie:5.2.0"

    //ijk
    const val ijkPlayer = "tv.danmaku.ijk.media:ijkplayer-java:0.8.8"

    //美团打包
    const val walle = "com.meituan.android.walle:library:1.1.7"

    //banner
    const val banner = "com.github.zhpanvip:bannerviewpager:3.5.12"

    const val mmkv = "com.tencent:mmkv-static:1.2.13"

    //语言切换
    const val multiLanguages = "com.github.getActivity:MultiLanguages:9.3"
}