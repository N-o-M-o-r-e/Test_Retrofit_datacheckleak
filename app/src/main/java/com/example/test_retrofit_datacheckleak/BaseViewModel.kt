package com.example.testretrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel(application: Application, private val handle: SavedStateHandle) :
    AndroidViewModel(application) {
    val scope: CoroutineScope
        get() = viewModelScope

    fun saveDataStore() {

    }

    fun restoreData() {

    }

}