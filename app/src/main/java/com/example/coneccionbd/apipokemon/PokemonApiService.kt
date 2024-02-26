package com.example.coneccionbd.apipokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
  //  @GET("pokemon/{id}")
   @GET("pokemon") fun  getPokemonById(): Call<Pokemones>
}
