package com.loc.newsapp.presentation.navgraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.loc.newsapp.navgraph.Route
import com.loc.newsapp.prensentation.bookmark.BookmarkScreen
import com.loc.newsapp.prensentation.bookmark.BookmarkViewModel
import com.loc.newsapp.prensentation.home.SearchBar
import com.loc.newsapp.prensentation.onboarding.OnBoardingScreen
import com.loc.newsapp.prensentation.onboarding.OnBoardingViewModel
import com.loc.newsapp.presentation.home.HomeScreen
import com.loc.newsapp.presentation.news_navigator.NewsNavigator
import com.loc.newsapp.presentation.search.SearchScreen
import com.loc.newsapp.presentation.search.SearchViewModel


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewNavigatorScreen.route
        ) {
            composable(route = Route.NewNavigatorScreen.route){
                NewsNavigator()
            }
        }
    }
}