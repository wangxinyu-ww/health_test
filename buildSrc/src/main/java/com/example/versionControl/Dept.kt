/**
 * android依赖库
 *
 *  - 若库的版本有`ktx`和非`ktx`，则只需要依赖`ktx`版本即可[doc](https://developer.android.com/kotlin/ktx)
 *
 */
object Android {
    /**
     * [Java8 Support](https://developer.android.com/studio/write/java8-support#kts)
     */
    const val desugarJdkLib = "com.android.tools:desugar_jdk_libs:1.1.5"
    const val appCompat = "androidx.appcompat:appcompat:1.4.1"
    const val material = "com.google.android.material:material:1.6.0"
    const val activity = "androidx.activity:activity:1.4.1"
    const val constraint = "androidx.constraintlayout:constraintlayout:2.1.3"

    const val multiDex = "androidx.multidex:multidex:2.0.1"

    //startup
    const val startUp = "androidx.startup:startup-runtime:1.1.1"
    const val splashscreen = "androidx.core:core-splashscreen:1.0.0-alpha02"
    const val recyclerviewSelection = "androidx.recyclerview:recyclerview-selection:1.1.0"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    //navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment:${Version.Android.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Version.Android.navigation}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Version.Android.navigation}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Version.Android.navigation}"

    //viewpager
    const val viewPager2 = "androidx.viewpager2:viewpager2:1.1.0-alpha01"

    const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.1"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:2.4.1"

    //net
    const val fastjson = "com.alibaba:fastjson:1.2.49"

    //preference
    const val preference = "androidx.preference:preference:1.1.1"


    //imageLoader
    const val imageLoader = "com.nostra13.universalimageloader:universal-image-loader:1.9.5"

    const val superCsv = "net.sf.supercsv:super-csv:2.4.0"
}

object DataStore {
    const val typed = "androidx.datastore:datastore:${Version.Android.datastore}"
    const val typedRxJava3 = "androidx.datastore:datastore-rxjava3:${Version.Android.datastore}"

    const val preference =
        "androidx.datastore:datastore-preferences:${Version.Android.datastore}"
    const val preferenceRxJava3 =
        "androidx.datastore:datastore-preferences-rxjava3:${Version.Android.datastore}"

    const val protoJavaLite = "com.google.protobuf:protobuf-javalite:3.19.3"
    const val protoc = "com.google.protobuf:protoc:3.19.3"
}

object Github {
    //gilde
    const val glide = "com.github.bumptech.glide:glide:4.13.0"
    const val glideCompiler = "com.github.bumptech.glide:compiler:4.13.0"

    //permission
    const val rxPermission = "com.github.tbruyelle:rxpermissions:0.12"

    const val refresh_header = "io.github.scwang90:refresh-header-classics:2.0.5"
    const val refresh_layout = "io.github.scwang90:refresh-layout-kernel:2.0.5"
    const val banner = "io.github.youth5201314:banner:2.2.2"

}

object Paging {
    const val runtime = "androidx.paging:paging-runtime:${Version.Android.paging}"

    // optional - RxJava3 support
    const val rxjava3 = "androidx.paging:paging-rxjava3:${Version.Android.paging}"

    // optional - Jetpack Compose integration
    const val compose = "androidx.paging:paging-compose:1.0.0-alpha14"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Version.Android.room}"
    const val compiler = "androidx.room:room-compiler:${Version.Android.room}"
    const val ktx = "androidx.room:room-ktx:${Version.Android.room}"

    //Optional
    const val rxJava3 = "androidx.room:room-rxjava3:${Version.Android.room}"

    //Optional Guava support for Room, including Optional and ListenableFuture
    const val guava = "androidx.room:room-guava:${Version.Android.room}"

    // optional - Paging 3 Integration
    const val paging = "androidx.room:room-paging:${Version.Android.room}"
}

object RxJava {
    const val rxJava = "io.reactivex.rxjava3:rxjava:3.0.12"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:3.0.0"
}

object Net {
    //network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Android.retrofit}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Version.Android.retrofit}"
    const val retrofitAdapterRxjava3 =
        "com.squareup.retrofit2:adapter-rxjava3:${Version.Android.retrofit}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Version.Android.okhttp}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Version.Android.okhttp}"
}

object Hilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.Android.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.Android.hilt}"
}

object TinyPinyin {
    const val tinyPinyin = "com.github.promeg:tinypinyin:2.0.3"
    const val tinyPinyinAndroid = "com.github.promeg:tinypinyin-lexicons-android-cncity:2.0.3"
    const val tinyPinyinCity = "com.github.promeg:tinypinyin-lexicons-android-cncity:2.0.3"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:1.7.0"
}

object TestLib {
    const val junit4 = "junit:junit:4.13.2"
    const val junit5 = "org.junit.jupiter:junit-jupiter-api:${Version.jUnit5}"
    const val junit5Engine = "org.junit.jupiter:junit-jupiter-engine:${Version.jUnit5}"
}

object LogLib {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
}

object BuildConfig {
    const val minSdk = 17
    const val targetSdk = 31
    const val compileSdk = 31
}

object Version {
    const val kotlin = "1.6.20"
    const val jUnit5 = "5.3.1"

    object Android {
        const val navigation = "2.4.0-beta02"
        const val hilt = "2.41"
        const val okhttp = "4.9.3"
        const val room = "2.4.1"
        const val datastore = "1.0.0"
        const val safeArgs = "2.3.5"
        const val retrofit = "2.9.0"
        const val paging = "3.1.1"
    }
}
