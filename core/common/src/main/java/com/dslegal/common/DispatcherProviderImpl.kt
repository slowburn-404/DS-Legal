package com.dslegal.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DispatcherProviderImpl : DispatcherProvider {
    override val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}