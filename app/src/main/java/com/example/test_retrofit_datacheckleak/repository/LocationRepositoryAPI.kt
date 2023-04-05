package com.example.test_retrofit_datacheckleak.repository

import android.app.Application
import com.example.testretrofit.api.ApiConfig
import com.example.testretrofit.model.DataLeakCheck
import retrofit2.http.Body

class LocationRepositoryAPI(application: Application) {
    companion object{
        private var instance :LocationRepositoryAPI?=null
        fun newInstance(application: Application): LocationRepositoryAPI {
            if (instance == null) {
                instance = LocationRepositoryAPI(application)
            }
            return instance!!
        }
    }
    suspend fun getLocation(body : HashMap<String, String>) = ApiConfig.apiLocationService.sendTest(body)
}
