package com.dslegal.data.di

import com.dslegal.data.repositories.AuthenticationRepositoryImpl
import com.dslegal.domain.repository.AuthenticationRepository
import org.koin.dsl.module

val dataModule = module {
    single<AuthenticationRepository> {
        AuthenticationRepositoryImpl(
            userApiService = get()
        )
    }

}