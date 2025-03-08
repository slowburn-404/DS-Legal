plugins {
    alias(libs.plugins.dslegal.android.library.compose)
    alias(libs.plugins.dslegal.koin)
}

android {
    namespace = "com.dslegal.ui"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}