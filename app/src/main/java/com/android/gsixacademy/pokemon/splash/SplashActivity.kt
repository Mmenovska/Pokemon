package com.android.gsixacademy.pokemon.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.pokemon.list.PokemonListActivity
import com.android.gsixacademy.pokemon.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        GlobalScope.launch {
            Thread.sleep(1000)
            startActivity(Intent(applicationContext, PokemonListActivity::class.java))
            finish()
        }
    }
}