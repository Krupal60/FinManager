package com.krupal.finmanager.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.krupal.finmanager.domain.preference.Preference
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.Preference : DataStore<Preferences> by preferencesDataStore("settings")

@Singleton
class MyPreferences@Inject constructor(
    @ApplicationContext context: Context
) : Preference {

    private val pref = context.Preference

   companion object{
       val APP_ENTARY_KEY = booleanPreferencesKey("app_entry")
   }

    override suspend fun SaveOnBoard() {
        pref.edit { preferences ->
            preferences[APP_ENTARY_KEY] = true
        }
    }

    override  fun GetOnBoard(): Flow<Boolean> {
       return pref.data.catch {
               emptyPreferences()
           }.map {
              it[APP_ENTARY_KEY] ?: false
           }

    }

}