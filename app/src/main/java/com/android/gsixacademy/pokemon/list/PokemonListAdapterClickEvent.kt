package com.android.gsixacademy.pokemon.list

import com.android.gsixacademy.pokemon.models.PokemonResult

sealed class PokemonListAdapterClickEvent {
    data class PokemonListAdapterItemClicked (val pokemonResult : PokemonResult) : PokemonListAdapterClickEvent()
}

