plugins {
    alias(libs.plugins.dslegal.android.library.compose)
    alias(libs.plugins.dslegal.koin)
}

android {
    namespace = "com.dslegal.authentication"
}

dependencies {
    api(project(":core:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}