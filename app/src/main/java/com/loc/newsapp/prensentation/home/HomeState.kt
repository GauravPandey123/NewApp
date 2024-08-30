package com.loc.newsapp.prensentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)