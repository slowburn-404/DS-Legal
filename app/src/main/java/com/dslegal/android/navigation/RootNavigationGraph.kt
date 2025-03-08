package com.dslegal.android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dslegal.authentication.navigation.AuthenticationNavigator
import com.dslegal.authentication.navigation.authenticationNavGraph
import org.koin.compose.getKoin
import org.koin.core.parameter.parametersOf

@Composable
fun RootNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
    snackBarHostState: SnackbarHostState
) {
    val authNavigator: AuthenticationNavigator = getKoin().get { parametersOf(navController) }

    NavHost(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(paddingValues)
            .imePadding(),
        navController = navController,
        startDestination = AppRoutes.Authentication.route
    ) {

        authenticationNavGraph(
            authenticationNavigator = authNavigator,
            route = AppRoutes.Authentication.route,
            snackBarHostState = snackBarHostState
        )
    }

}