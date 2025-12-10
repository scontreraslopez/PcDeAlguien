package net.iessochoa.sergiocontreras.pcdealguien.network

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    // TODO 2: Definir el endpoint
    // 🟢 Done: Ojo es más completo que el codelab porque en el codelab no se usaba Path. También está el Query pero no lo usaremos aquí

    // GET generation/{id}/
    // Recuerda que debe ser una función 'suspend' si usamos Corrutinas directamente o devolver Call

    // suspend fun getGeneration...

    /* Sabemos que nuestras llamadas van a ser:
     - 1. https://pokeapi.co/api/v2/generation/ para obtener la lista de generaciones
     - 2. https://pokeapi.co/api/v2/generation/{generation_id}/ para obtener la lista de pokemons asociados a esa generación

     Ojo luego tenemos que montarle la imagen al pokemon para eso usamos el official artwork:
    - 3. https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/{pokemon_id}.png

      Tenemos en cuenta que parte será la baseUrl
     */


    /* 1. Obtener la lista de generaciones (usa GenerationsResponse)
     */
    @GET("generation")
    suspend fun getGenerations(): GenerationsResponse


    // 2. Obtener los pokemons de UNA generación específica
    // El {id} se sustituye por 1, 2, 3...
    // Devuelve tu PokemonGenerationResponse
    @GET("generation/{id}")
    suspend fun getGenerationPokemons(@Path("id") id: Int): PokemonGenerationResponse
}