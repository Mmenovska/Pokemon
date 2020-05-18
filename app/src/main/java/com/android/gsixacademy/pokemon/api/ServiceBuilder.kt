package com.android.gsixacademy.pokemon.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    val client = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildService (service : Class <T>) : T {
        return retrofit.create(service)
    }
}