package com.rjt.retrofitrxjava.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object{

        var BASE_URL = "https://jsonplaceholder.typicode.com"

        fun getRetrofit(): Retrofit {

            var retrofit = Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit
        }


    }


}