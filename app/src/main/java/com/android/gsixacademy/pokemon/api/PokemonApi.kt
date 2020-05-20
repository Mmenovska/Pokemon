package com.android.gsixacademy.pokemon.api

import com.android.gsixacademy.pokemon.models.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET ("api/v2/pokemon/")
    fun getPokemonList (@Query ("offset") offset : Int, @Query ("limit") limit : Int) : Call<PokemonListResponse>

}