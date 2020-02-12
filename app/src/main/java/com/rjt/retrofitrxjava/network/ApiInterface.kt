package com.rjt.retrofitrxjava.network

import com.rjt.retrofitrxjava.models.Users
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    fun getUsers() : Single<List<Users>>
}