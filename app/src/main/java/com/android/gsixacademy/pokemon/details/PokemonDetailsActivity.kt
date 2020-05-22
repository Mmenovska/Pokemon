package com.android.gsixacademy.pokemon.details

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.pokemon.R
import com.android.gsixacademy.pokemon.api.PokemonApi
import com.android.gsixacademy.pokemon.api.ServiceBuilder
import com.android.gsixacademy.pokemon.list.PokemonListAdapter
import com.android.gsixacademy.pokemon.models.PokemonDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonDetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)


        image_view__back.setOnClickListener{ onBackPressed()        }


        var pokemonName = intent.getStringExtra("pokemonName")
        text_view_pokemon_name.text = pokemonName
        var pokemonUrl = intent.getStringExtra("pokemonImage")
        var pokemonId = pokemonUrl?.trimEnd ('/')?.substringAfterLast('/')
        Picasso.get().load("https://pokeres.bastionbot.org/images/pokemon/${pokemonId}.png").fit().centerInside().into(image_view_pokemon_detail)

        val request = ServiceBuilder.buildService(PokemonApi::class.java)
        val call = request.getPokemonDetails(pokemonName)
        call.enqueue(object : Callback <PokemonDetails>{
            override fun onResponse(
                call: Call<PokemonDetails>,
                response: Response<PokemonDetails>
            ) {
                if (response.isSuccessful){
                    fillPokemonData(response.body())





                }
            }

            override fun onFailure(call: Call<PokemonDetails>, t: Throwable) {
                Toast.makeText(applicationContext, "api error", Toast.LENGTH_LONG).show()
            }
        })



    }
    private fun fillPokemonData (pokemonDetails: PokemonDetails?){
        text_view_info_name.text =pokemonDetails?.name
        text_view_height.text = "Height: ${pokemonDetails?.height} m"
        text_view_weight.text = "Weight: ${pokemonDetails?.weight} kg"
        if (pokemonDetails?.types != null && pokemonDetails?.types?.size > 0)
        text_view_ability.text = pokemonDetails.types.get(0)?.type?.name ?:""
        if (pokemonDetails?.types != null && pokemonDetails?.types?.size > 1) {
            text_view_ability_two.text = pokemonDetails.types.get(1).type?.name ?: ""
        }else {
            text_view_ability_two.visibility = View.INVISIBLE
        }






    }
}