package com.example.testretrofit.api

import com.example.test_retrofit_datacheckleak.api.ApiLocationService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        const val BASE_URL= "https://webapi.namescan.io/"
        private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val apiLocationService: ApiLocationService = retrofit.create(ApiLocationService::class.java)
    }
    val retrofit = Retrofit.Builder()
        .baseUrl("https://webapi.namescan.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

        val apiLocationService = retrofit.create(ApiLocationService::class.java)
}