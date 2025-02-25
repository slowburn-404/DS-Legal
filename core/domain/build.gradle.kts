plugins {
    alias(libs.plugins.dslegal.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.dslegal.domain"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}