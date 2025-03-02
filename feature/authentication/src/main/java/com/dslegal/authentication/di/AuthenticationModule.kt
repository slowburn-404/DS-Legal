package com.dslegal.authentication.di

import com.dslegal.authentication.RegisterViewModel
import com.dslegal.domain.di.domainModule
import org.koin.dsl.module

val authenticationModule = module {
    includes(domainModule)

    single<RegisterViewModel> {
        RegisterViewModel(
            registerUseCase = get()
        )
    }
}