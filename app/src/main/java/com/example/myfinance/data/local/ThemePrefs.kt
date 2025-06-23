package com.example.myfinance.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.myfinance.domain.model.settings.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemePrefs @Inject constructor(
    private val context: Context
) {
    private val dataStore = context.themeDataStore

    companion object {
        private val THEME_KEY = androidx.datastore.preferences.core.stringPreferencesKey("theme_key")
    }

    fun getTheme(): Flow<AppTheme> = dataStore.data.map { prefs ->
        val themeName = prefs[THEME_KEY] ?: AppTheme.SYSTEM.name
        AppTheme.valueOf(themeName)
    }

    suspend fun setTheme(theme: AppTheme) {
        dataStore.edit { prefs ->
            prefs[THEME_KEY] = theme.name
        }
    }
}
