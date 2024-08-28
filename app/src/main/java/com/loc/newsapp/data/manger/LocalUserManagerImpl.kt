package com.loc.newsapp.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.utils.Constants.App_Entry
import com.loc.newsapp.utils.Constants.User_Setting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {settings->
            settings[PrefrenceKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { prefrencekeys->
            prefrencekeys[PrefrenceKeys.APP_ENTRY] ?: false

        }
    }
}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name =User_Setting)

private object PrefrenceKeys{
    val APP_ENTRY = booleanPreferencesKey(name =App_Entry)
}