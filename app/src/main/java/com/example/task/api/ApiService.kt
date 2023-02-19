package com.example.task.api

import com.example.task.model.Data
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET()
    suspend fun getData(): Data
}

val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit: Retrofit =
    Retrofit.Builder()
        .baseUrl("https://mobile-olympiad-trajectory.hb.bizmrg.com/semi-final-data.json")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

object DataApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
