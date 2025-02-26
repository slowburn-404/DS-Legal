package com.dslegal.datastore.utils

import androidx.datastore.preferences.core.stringPreferencesKey

object TokenPreferences {
    val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
}