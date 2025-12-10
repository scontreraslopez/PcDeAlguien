package net.iessochoa.sergiocontreras.pcdealguien.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    // Estado para la lista de pokemons
    val _uiState = MutableStateFlow(PokemonScreenUiState())
    val uiState: StateFlow<PokemonScreenUiState> = _uiState.asStateFlow()

    // Función para llamar a la API
    fun fetchPokemonByGeneration(generationId: Int) {
        viewModelScope.launch {
            try {
                // TODO 4: Llamar a RetrofitClient y actualizar _pokemonList
                // val response = RetrofitClient.service.getGeneration(generationId)
                // _pokemonList.value = ...

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}