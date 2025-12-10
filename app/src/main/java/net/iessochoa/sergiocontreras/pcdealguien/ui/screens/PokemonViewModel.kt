package net.iessochoa.sergiocontreras.pcdealguien.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.pcdealguien.PokemonApplication
import net.iessochoa.sergiocontreras.pcdealguien.data.PokemonRepository

class PokemonViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    // Estado para la lista de pokemons. Arranca cargando y el resto lo de siempre
    val _uiState = MutableStateFlow(PokemonUiState(
        pokemons = listOf(),
        isLoading = true,
        ))
    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    //Al init lo que hay que hacer es pescar las generations y con eso darle los valores al dropdown
    init {
        getGenerations()
    }

    private fun getGenerations() {
        viewModelScope.launch {
            try {
                //Cogemos la lista de generations del repository
                val generationList = pokemonRepository.getGenerations()
                _uiState.update { currentState ->
                    val generationsCount = generationList.count()
                    currentState.copy(
                        generations = generationsCount,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(isError = true, isLoading = false)
                }
            }
        }
    }

    fun selectGeneration(generation: String) {
        _uiState.update { currentState ->
            currentState.copy(selectedGeneration = generation.toIntOrNull() ?: 1)
        }
    }

    // Función para llamar a la API
    fun fetchPokemonByGeneration(generationId: Int) {
        viewModelScope.launch {
            try {
                // Primero lo ponemos a que está cargando
                _uiState.update { currentState ->
                    currentState.copy(isLoading = true)
                }
                // ahora cargamos los pokemons para esa generation

                 val pokemonList = pokemonRepository.getGenerationPokemons(generationId)
                //Ahora actualizamos
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, pokemons = pokemonList)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokemonViewModel(pokemonRepository = pokemonRepository)
            }
        }
    }
}