package com.dslegal.android

import android.app.Application
import com.dslegal.authentication.di.authenticationModule
import com.dslegal.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DSLegalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DSLegalApplication)
            androidLogger(Level.INFO)
            modules(dataModule, authenticationModule)
        }
    }
}