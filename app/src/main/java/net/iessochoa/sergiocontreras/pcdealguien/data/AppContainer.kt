package net.iessochoa.sergiocontreras.pcdealguien.data

import kotlinx.serialization.json.Json
import net.iessochoa.sergiocontreras.pcdealguien.network.PokeApiService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

// Primero le enganchamos el/los repository a la interface
interface AppContainer {
    val pokemonRepository: PokemonRepository
}

class DefaultAppContainer: AppContainer {
    private val baseUrl = "https://pokeapi.co/api/v2/"

    //Empezamos a inicializar primero Retrofit, siempre lazy.
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }

    private val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }

    override val pokemonRepository: PokemonRepository by lazy {
        NetworkPokemonRepository(retrofitService)

    }
}
