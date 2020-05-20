package com.android.gsixacademy.pokemon.details

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.pokemon.R
import com.android.gsixacademy.pokemon.list.PokemonListActivity
import kotlinx.android.synthetic.main.activity_pokemon_details.*

class PokemonDetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)


        image_view__back.setOnClickListener{ onBackPressed()        }

        var pokemonName = intent.getStringExtra("pokemonName")
        text_view_pokemon_name.text = pokemonName


    }
}