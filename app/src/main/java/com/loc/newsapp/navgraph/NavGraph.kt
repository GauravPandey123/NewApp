package com.loc.newsapp.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.prensentation.onboarding.OnBoardingScreen
import com.loc.newsapp.prensentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(startDestination : String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){
      navigation(
          route = Route.AppStartNavigation.route,
          startDestination = Route.OnBoardingScreen.route
      ){
          composable(route = Route.OnBoardingScreen.route){
              val viewModel : OnBoardingViewModel = hiltViewModel()
              OnBoardingScreen(
                  event = viewModel::onEvent
              )
          }
      }
        navigation(route = Route.NewsNavigation.route,
                   startDestination = Route.NewNavigatorScreen.route){
            composable(route = Route.NewNavigatorScreen.route){
                Text(text = "News Navigator Screen")

            }
        }
    }

}