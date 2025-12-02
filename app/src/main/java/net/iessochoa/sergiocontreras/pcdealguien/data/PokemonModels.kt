package net.iessochoa.sergiocontreras.pcdealguien.data

// TODO 1: Crear las Data Classes según el JSON de https://pokeapi.co/api/v2/generation/{id}/

data class GenerationResponse(
    // TODO: Mapear el array "pokemon_species"
    val id: Int = 0
)

data class PokemonSpecies(
    // TODO: Necesitamos el nombre y la url para luego sacar el ID
    val name: String = ""
)