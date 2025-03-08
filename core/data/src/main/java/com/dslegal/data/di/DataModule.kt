package com.dslegal.data.di

import com.dslegal.common.DispatcherProvider
import com.dslegal.common.di.commonModule
import com.dslegal.data.repositories.AuthenticationRepositoryImpl
import com.dslegal.data.repositories.TokenRepositoryImpl
import com.dslegal.datastore.di.dataStoreModule
import com.dslegal.domain.di.domainModule
import com.dslegal.domain.repositories.AuthenticationRepository
import com.dslegal.domain.repositories.TokenRepository
import com.dslegal.network.di.networkModule
import com.dslegal.network.services.auth.UserApiService
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.module

val dataModule = module {

    includes(dataStoreModule, domainModule, networkModule, commonModule)

    single<AuthenticationRepository> {
        AuthenticationRepositoryImpl(
            userApiService = get<UserApiService>(),
            coroutineDispatcher = get<DispatcherProvider>()
        )
    }

    single<TokenRepository> {
        TokenRepositoryImpl(
            tokenManager = get(),
            coroutineDispatcher = get()
        )
    }
}