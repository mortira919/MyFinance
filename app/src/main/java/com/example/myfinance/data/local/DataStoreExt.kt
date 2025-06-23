package com.example.myfinance.data.local

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "settings")
val Context.themeDataStore by preferencesDataStore(name = "theme_prefs")