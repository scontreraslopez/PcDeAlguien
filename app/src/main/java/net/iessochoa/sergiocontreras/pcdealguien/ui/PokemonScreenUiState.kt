package net.iessochoa.sergiocontreras.pcdealguien.ui

import net.iessochoa.sergiocontreras.pcdealguien.data.PokemonSpecies


data class PokemonScreenUiState (
    val pokemonList: List<PokemonSpecies> = emptyList(),

    // Un booleano para saber si estamos cargando (Opcional pero recomendado)
    val isLoading: Boolean = false,

    // Podríamos añadir un mensaje de error si quisiéramos
    val errorMessage: String? = null
)