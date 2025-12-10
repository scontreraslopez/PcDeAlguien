package net.iessochoa.sergiocontreras.pcdealguien.ui.screens

import net.iessochoa.sergiocontreras.pcdealguien.network.PokemonDto


// La solución de máximos es trirar por aquí y definir varios uiStates para generations y para pokemons
/*
//Agárrate los machos que vienen curvas
// 1. Definimos los estados posibles (Sealed Interface). Esto así es mutuamente excluyente y más seguro ahora hay situaciones en las que querremos nuestra clásica data class
sealed interface PokemonUiState {
    data class Success(val pokemons: List<PokemonDto>) : PokemonUiState // Quizá toque cambiarlo a un Pokemon model
    object Error : PokemonUiState
    object Loading : PokemonUiState
}
*/

/* Tiramos con nuestra simplificación didáctica por que si no el viewModel se complica mucho */
data class PokemonUiState(
    val generations: Int = 1, //Mejor le pongo 1 por defecto que sino puede crashear
    val pokemons: List<PokemonDto>,
    val isError: Boolean = false,
    val isLoading: Boolean = true,
    val selectedGeneration: Int = 1 //La he tenido que subir por que la necesito para el fetch
)