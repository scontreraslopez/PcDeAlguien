package net.iessochoa.sergiocontreras.pcdealguien

import android.app.Application
import net.iessochoa.sergiocontreras.pcdealguien.data.AppContainer
import net.iessochoa.sergiocontreras.pcdealguien.data.DefaultAppContainer

/**
 * Project: PCdeAlguien
 * From: net.iessochoa.sergiocontreras.pcdealguien
 * Created by: Contr
 * On: 10/12/2025 at 22:55
 * Creado en Settings -> Editor -> File and Code Templates
 */
class PokemonApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}

