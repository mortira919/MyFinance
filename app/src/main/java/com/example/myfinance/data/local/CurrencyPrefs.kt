package com.example.myfinance.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyPrefs @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        val SELECTED_CURRENCY = stringPreferencesKey("selected_currency")
    }

    suspend fun saveCurrency(code: String) {
        dataStore.edit { prefs ->
            prefs[SELECTED_CURRENCY] = code
        }
    }

    val selectedCurrency: Flow<String> = dataStore.data
        .map { prefs -> prefs[SELECTED_CURRENCY] ?: "KZT" }
}
