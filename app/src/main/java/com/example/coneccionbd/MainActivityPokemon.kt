package com.example.coneccionbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.coneccionbd.apipokemon.Pokemon
import com.example.coneccionbd.apipokemon.PokemonApiService
import com.example.coneccionbd.apipokemon.Pokemones
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pokemon)
        val text = findViewById<TextView>(R.id.textView)
        val img= findViewById<ImageView>(R.id.img)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PokemonApiService::class.java)

        val call = service.getPokemonById()

        call.enqueue(object : Callback<Pokemones> {
            override fun onResponse(call: Call<Pokemones>, response: Response<Pokemones>){
                if (response.isSuccessful) {
                    val pokemones: Pokemones? = response.body()
                    Toast.makeText(this@MainActivityPokemon, "El consumido es$pokemones", Toast.LENGTH_SHORT).show()
                    text.text = pokemones.toString()
                    Picasso.get()
                        .load("https://centrodepsicologiademadrid.es/wp-content/uploads/2018/11/rabiaytristeza.jpg")
                        .into(img);
                } else {

                }
            }
            override fun onFailure(call: Call<Pokemones>, t: Throwable){

            }
        })
    }
}