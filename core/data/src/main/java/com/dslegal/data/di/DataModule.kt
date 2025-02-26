package com.dslegal.data.di

import com.dslegal.data.repositories.AuthenticationRepositoryImpl
import com.dslegal.data.repositories.TokenRepositoryImpl
import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.domain.repositories.TokenRepository
import org.koin.dsl.module

val dataModule = module {
    single<AuthenticationRepository> {
        AuthenticationRepositoryImpl(
            userApiService = get()
        )
    }

    single<TokenRepository> {
        TokenRepositoryImpl(
            tokenManager = get()
        )
    }
}