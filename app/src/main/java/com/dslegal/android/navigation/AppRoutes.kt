package com.dslegal.android.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoutes(
    val route: String
) {
    @Serializable
    data object Authentication : AppRoutes(route = "feat_auth")
}