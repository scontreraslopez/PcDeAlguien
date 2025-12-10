package net.iessochoa.sergiocontreras.pcdealguien

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.sergiocontreras.pcdealguien.ui.screens.PokemonScreen
import net.iessochoa.sergiocontreras.pcdealguien.ui.screens.PokemonViewModel

/**
 * Project: PCdeAlguien
 * From: net.iessochoa.sergiocontreras.pcdealguien
 * Created by: Contr
 * On: 10/12/2025 at 11:35
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun PokemonApp(
    viewModel: PokemonViewModel = viewModel()
    ) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        PokemonScreen(
            uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
            onFetchClick = {viewModel.fetchPokemonByGeneration(uiState.selectedGeneration)},
            onGenerationSelection = {viewModel.selectGeneration(uiState.selectedGeneration.toString())},
            modifier = Modifier.padding(innerPadding))
    }
}