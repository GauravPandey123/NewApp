package com.loc.newsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.loc.newsapp.domain.usecases.AppEntryUseCases
import com.loc.newsapp.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: AppEntryUseCases
) : ViewModel() {
    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)

    init {
        useCases.readerAppEntry().onEach { shouldStartFromHomeScreen ->
            startDestination = if (shouldStartFromHomeScreen) {
                Route.NewsNavigation.route
            } else {
                Route.NewsNavigation.route
            }
            delay(300)
            _splashCondition.value = false
        }
    }


}