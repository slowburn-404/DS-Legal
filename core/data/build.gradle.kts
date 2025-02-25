plugins {
    alias(libs.plugins.dslegal.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.dslegal.data"
}

dependencies {
    api(project(":core:network"))
    api(project(":core:datastore"))

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}