package com.templatesfjr.nubank

import com.templatesfjr.nubank.utils.NubankRouter
import com.templatesfjr.nubank.view.main.WelcomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object NubankInjector {
    fun init() = listOf(
        viewModelModule
    )
}

fun loadNubankKoinModules() {
    loadKoinModules(NubankInjector.init())
}

private val viewModelModule = module {
    viewModel { (router: NubankRouter) ->
        WelcomeViewModel(router)
    }
}
