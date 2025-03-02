package com.dslegal.domain.di

import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.domain.usecases.RegisterUseCase
import com.dslegal.domain.usecases.RegisterUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<RegisterUseCase> {

        RegisterUseCaseImpl(
            authenticationRepository = get()
        )
    }

}