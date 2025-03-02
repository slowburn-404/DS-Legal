package com.dslegal.data.di

import com.dslegal.common.di.commonModule
import com.dslegal.data.repositories.AuthenticationRepositoryImpl
import com.dslegal.data.repositories.TokenRepositoryImpl
import com.dslegal.datastore.di.dataStoreModule
import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.domain.repositories.TokenRepository
import com.dslegal.network.di.networkModule
import org.koin.dsl.module

val dataModule = module {
    includes(networkModule, dataStoreModule, commonModule)

    single<AuthenticationRepository> {
        AuthenticationRepositoryImpl(
            userApiService = get(),
            coroutineDispatcher = get()
        )
    }

    single<TokenRepository> {
        TokenRepositoryImpl(
            tokenManager = get(),
            coroutineDispatcher = get()
        )
    }
}