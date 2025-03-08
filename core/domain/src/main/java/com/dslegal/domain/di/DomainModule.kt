package com.dslegal.domain.di

import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.domain.usecases.RegisterUseCase
import com.dslegal.domain.usecases.RegisterUseCaseImpl
import com.dslegal.domain.usecases.VerifyEmailUseCase
import com.dslegal.domain.usecases.VerifyEmailUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<RegisterUseCase> {

        RegisterUseCaseImpl(
            authenticationRepository = get<AuthenticationRepository>()
        )
    }

    single<VerifyEmailUseCase> {
        VerifyEmailUseCaseImpl(
            authenticationRepository = get<AuthenticationRepository>()
        )
    }

}