package net.iessochoa.sergiocontreras.pcdealguien

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.pcdealguien.ui.PokemonScreen

/**
 * Project: PCdeAlguien
 * From: net.iessochoa.sergiocontreras.pcdealguien
 * Created by: Contr
 * On: 10/12/2025 at 11:35
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun PokemonApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        PokemonScreen(modifier = Modifier.padding(innerPadding))
    }
}