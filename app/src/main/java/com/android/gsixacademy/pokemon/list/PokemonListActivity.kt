package com.android.gsixacademy.pokemon.list


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.gsixacademy.pokemon.R
import com.android.gsixacademy.pokemon.api.PokemonApi
import com.android.gsixacademy.pokemon.api.ServiceBuilder
import com.android.gsixacademy.pokemon.details.PokemonDetailsActivity
import com.android.gsixacademy.pokemon.models.PokemonListResponse
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)


        val request = ServiceBuilder.buildService(PokemonApi::class.java)
        val call = request.getPokemonList(0, 50)
        call.enqueue(object : Callback<PokemonListResponse> {
            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Api Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                var pokemonListResponse = response.body()
                var pokemons = pokemonListResponse?.results
                if (pokemons != null) {
                    var pokemonListAdapter = PokemonListAdapter(pokemons) {
                        if (it is PokemonListAdapterClickEvent.PokemonListAdapterItemClicked){
                        startActivity(Intent(applicationContext, PokemonDetailsActivity::class.java).putExtra("pokemonName",it.pokemonResult.name))
                    }}
                    recycle_view_pokemons.adapter = pokemonListAdapter

                }
            }
        })

    }
}
