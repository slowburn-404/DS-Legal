package com.dslegal.authentication.di

import androidx.navigation.NavController
import com.dslegal.authentication.BaseViewModel
import com.dslegal.authentication.navigation.AuthenticationNavigator
import com.dslegal.authentication.navigation.AuthenticationNavigatorImpl
import com.dslegal.domain.di.domainModule
import com.dslegal.domain.usecases.RegisterUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authenticationModule = module {
    includes(domainModule)

    viewModel<BaseViewModel> {
        BaseViewModel(
            registerUseCase = get<RegisterUseCase>()
        )
    }

    factory<AuthenticationNavigator> {
        AuthenticationNavigatorImpl(
            navController = get<NavController>()
        )
    }
}