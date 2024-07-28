package com.krupal.finmanager.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krupal.finmanager.data.datastore.MyPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val pref: MyPreferences
) : ViewModel() {
    var isLoading by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf<String>("")
        private set


    init {
        pref.GetOnBoard().onEach {
            startDestination = if (it) {
                "main"
            } else {
                "OnBoard"
            }
            delay(180)
            isLoading = false
        }.launchIn(viewModelScope)
    }

    fun saveOnBoard() {
        viewModelScope.launch {
            pref.SaveOnBoard()
        }
    }
}