package com.example.test_retrofit_datacheckleak.api

import com.example.testretrofit.model.DataLeakCheck
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface ApiLocationService {
    @POST("v1/freechecks/email/breaches")
    suspend  fun sendTest(@Body body: HashMap<String, String>): Response<Single<DataLeakCheck>>
}