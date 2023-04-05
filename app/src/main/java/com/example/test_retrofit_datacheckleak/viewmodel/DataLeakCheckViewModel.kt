package com.example.testretrofit.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import com.example.test_retrofit_datacheckleak.repository.LocationRepositoryAPI
import com.example.testretrofit.BaseViewModel
import com.example.testretrofit.utils.Resource
import kotlinx.coroutines.Dispatchers

class DataLeakCheckViewModel(application: Application, handle: SavedStateHandle) : BaseViewModel(application, handle) {
    val hasData: ObservableField<Boolean> by lazy { ObservableField(false) }
    private val locationRepositoryAPI : LocationRepositoryAPI by lazy {
        LocationRepositoryAPI.newInstance(getApplication())
    }

    fun getLocation(body : HashMap<String, String>) = liveData(Dispatchers.IO) {
        Log.e( "getLocation: ", body.toString() )
         emit(Resource.loading(null))
        try {
            emit(Resource.success(locationRepositoryAPI.getLocation(body)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.message ?: "null"))
        }
    }

}