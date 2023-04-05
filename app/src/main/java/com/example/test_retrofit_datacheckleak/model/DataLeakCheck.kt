package com.example.testretrofit.model

data class DataLeakCheck(
    val breaches: List<Breache>,
    val count: Int
)