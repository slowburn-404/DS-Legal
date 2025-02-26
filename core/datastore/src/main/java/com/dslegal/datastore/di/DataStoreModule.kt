package com.dslegal.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.dslegal.datastore.TokenManager
import com.dslegal.datastore.TokenManagerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


private const val AUTH_PREFERENCES_NAME = "auth_preferences"

private val Context.dataStore by preferencesDataStore(
    name = AUTH_PREFERENCES_NAME
)

private fun provideDataStore(context: Context): DataStore<Preferences> = context.dataStore


val dataStoreModule = module {
    single<DataStore<Preferences>> { provideDataStore(androidContext()) }

    single<TokenManager> {
        TokenManagerImpl(
            preferenceDataStore = get()
        )
    }
}