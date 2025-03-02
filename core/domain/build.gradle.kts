plugins {
    alias(libs.plugins.dslegal.android.library)
    alias(libs.plugins.dslegal.koin)
}

android {
    namespace = "com.dslegal.domain"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}