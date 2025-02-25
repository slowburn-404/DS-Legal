plugins {
    alias(libs.plugins.dslegal.android.library)
    alias(libs.plugins.dslegal.koin)
    alias(libs.plugins.dslegal.ktor)
}

android {
    namespace = "com.dslegal.network"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}