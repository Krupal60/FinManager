package com.krupal.finmanager.domain.preference

import kotlinx.coroutines.flow.Flow

interface Preference {
    suspend fun SaveOnBoard()
    fun GetOnBoard(): Flow<Boolean>
}