package com.dslegal.authentication.di

import androidx.navigation.NavHostController
import com.dslegal.authentication.BaseViewModel
import com.dslegal.authentication.navigation.AuthenticationNavigator
import com.dslegal.authentication.navigation.AuthenticationNavigatorImpl
import com.dslegal.domain.di.domainModule
import com.dslegal.domain.usecases.RegisterUseCase
import com.dslegal.domain.usecases.VerifyEmailUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authenticationModule = module {

    includes(domainModule)

    viewModel<BaseViewModel> {
        BaseViewModel(
           // registerUseCase = get<RegisterUseCase>(),
            verifyEmailUseCase = get<VerifyEmailUseCase>()
        )
    }

    factory<AuthenticationNavigator> {
        AuthenticationNavigatorImpl(
            navController = get<NavHostController>()
        )
    }
}