plugins {
    id("com.android.application")
}

android {
    namespace = "com.consed.projectfragmentapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.consed.projectfragmentapplication"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // size
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")


    // fButton
    implementation("info.hoang8f:fbutton:1.0.5")

    // مكتبة الصور picasso
    implementation("com.squareup.picasso:picasso:2.71828")


    implementation("com.android.volley:volley:1.2.1")


//    //Retrofit Api
//
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//

//     Room components
    implementation ("androidx.room:room-runtime:2.5.2")
    annotationProcessor ("androidx.room:room-compiler:2.5.2")
    androidTestImplementation ("androidx.room:room-testing:2.5.2")

//     Lifecycle components
//    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.3.1")
//    implementation ("androidx.lifecycle:lifecycle-livedata:2.3.1")
//    implementation ("androidx.lifecycle:lifecycle-common-java8:2.3.1")


}