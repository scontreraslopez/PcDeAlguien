package net.iessochoa.sergiocontreras.pcdealguien.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO 1: Crear las Data Classes según el JSON de https://pokeapi.co/api/v2/generation/{id}/
// 🟢 Done: Cuestion importante es que tenemos que decir que vamos a ignorar las que no cogemos del JSON en el archivo de configuracion AppContainer

@Serializable
data class GenerationsResponse(
    val results: List<GenerationDto>
)

@Serializable
data class GenerationDto(
    val name: String,
    val url: String
)

/* Con SerialName mapeamos nombre */
@Serializable
data class PokemonGenerationResponse(
    @SerialName(value="pokemon_species") val pokemons: List<PokemonDto>
)

/* Es importante que se ajuste a lo que manda el JSON, de ahí DTO o fallará */

@Serializable
data class PokemonDto(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)



