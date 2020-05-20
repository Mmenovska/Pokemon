package com.android.gsixacademy.pokemon.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.pokemon.R
import com.android.gsixacademy.pokemon.models.PokemonResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_results.view.*

class PokemonListAdapter (
    val itemList : ArrayList <PokemonResult>,
    val pokemonListAdapterClickEvent : (PokemonListAdapterClickEvent) -> Unit ): RecyclerView.Adapter<RecyclerView.ViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_pokemon_results,parent,false))
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var myViewHolder = holder as MyViewHolder
            myViewHolder.bindData(itemList [position], position)
        }

        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun bindData (itemModel : PokemonResult, position: Int) {
                itemView.text_view_name.text = itemModel.name
                itemView.text_view_position.text = position.toString()
                var pokemonId = itemModel.url?.trimEnd ('/')?.substringAfterLast('/')
                Picasso.get().load("https://pokeres.bastionbot.org/images/pokemon/${pokemonId}.png").fit().centerInside().into(itemView.image_view_pokemon)
            }
        }
    }