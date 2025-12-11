package net.iessochoa.sergiocontreras.pcdealguien.ui.screens

import net.iessochoa.sergiocontreras.pcdealguien.network.PokemonDto


// La solución de máximos es trirar por aquí y definir varios uiStates para generations y para pokemons
/*
//Agárrate los machos que vienen curvas
// 1. Definimos los estados posibles (Sealed Interface). Esto así es mutuamente excluyente y más seguro si usamos when.

*/

// UiState: Una sola clase que lo tiene todo
data class PokemonUiState(
    // Datos de la pantalla (persisten siempre)
    val selectedGeneration: Int = 1,
    val generations: Int = 1, // Podríamos poner 9 pero la gracia es que lo recupere de la API.
    // Estado de la petición (aquí usamos la lógica excluyente para la lista)
    val requestStatus: RequestStatus = RequestStatus.Idle  // Esto es lo mismo que hace el codelab con MarsPhoto
)

// Estado exclusivo solo para la carga de datos
sealed interface RequestStatus {
    object Idle : RequestStatus
    object Loading : RequestStatus
    data class Success(val pokemons: List<PokemonDto>) : RequestStatus
    object Error : RequestStatus
}




/* Tiramos con nuestra simplificación didáctica por que si no el viewModel se complica mucho */
data class OldPokemonUiState(
    val generations: Int = 1, // Arrancamos con 1 y que cargue el resto
    val pokemons: List<PokemonDto>,
    val isError: Boolean = false,
    val isLoading: Boolean = true,
    val selectedGeneration: Int = 1 // La he tenido que subir por que la necesito para el fetch
)



