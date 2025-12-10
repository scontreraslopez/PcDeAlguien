package net.iessochoa.sergiocontreras.pcdealguien.data

import net.iessochoa.sergiocontreras.pcdealguien.network.GenerationDto
import net.iessochoa.sergiocontreras.pcdealguien.network.PokeApiService
import net.iessochoa.sergiocontreras.pcdealguien.network.PokemonDto

// Interfaz para facilitar testing (Best Practice)
interface PokemonRepository{
    suspend fun getGenerationPokemons(generation: Int): List<PokemonDto>
    suspend fun getGenerations(): List<GenerationDto>
}

// Un detalle importante es que la interfaz nos abstrae de la fuente de los datos, claro implementamos una concreta que es Network por que en este particular caso cogemos de retrofit.


// Implementación concreta. Inyectamos el servicio, no lo creamos aquí
class NetworkPokemonRepository(
    private val apiService: PokeApiService
): PokemonRepository {
    override suspend fun getGenerationPokemons(generation: Int): List<PokemonDto> {
        return apiService.getGenerationPokemons(generation).pokemons
    }


    override suspend fun getGenerations(): List<GenerationDto> {
        return apiService.getGenerations().results
    }

}