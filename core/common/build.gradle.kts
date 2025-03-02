plugins {
    alias(libs.plugins.dslegal.android.library)
    alias(libs.plugins.dslegal.koin)
}

android {
    namespace = "com.dslegal.common"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}