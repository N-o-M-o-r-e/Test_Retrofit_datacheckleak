package com.example.test_retrofit_datacheckleak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.*
import androidx.databinding.DataBindingUtil
import com.example.test_retrofit_datacheckleak.R
import com.example.test_retrofit_datacheckleak.databinding.ActivityMainBinding
import com.example.testretrofit.api.ApiConfig
import com.example.testretrofit.utils.Status
import com.example.testretrofit.viewmodel.DataLeakCheckViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val createAccountViewModel: DataLeakCheckViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val requestBody = HashMap<String, String>()
        requestBody["email"] = "your_email@example.com"

//

        createAccountViewModel.getLocation(requestBody).observe(this) {
            Log.e("aaaa", it.toString())
            when (it.status) {
                Status.ERROR -> {}
                Status.SUCCESS -> {
                    Log.e("TAG", "listenLiveData:: ${it.data}")
                    Log.e("TAG", "message:: ${it.message}")

                }
                Status.LOADING -> {}
                else -> {
                }
            }

        }
    }
}