package com.dslegal.common.di

import com.dslegal.common.DispatcherProvider
import com.dslegal.common.DispatcherProviderImpl
import org.koin.dsl.module

val commonModule = module {

    single<DispatcherProvider> {
        DispatcherProviderImpl()
    }
}