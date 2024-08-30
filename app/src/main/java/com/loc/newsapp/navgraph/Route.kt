package com.loc.newsapp.navgraph

sealed class Route(val route : String) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object BookmarkScreen : Route(route = "bookMarkScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route ="newNavigation")
    object NewNavigatorScreen : Route(route = "newsNavigationScreen")
}