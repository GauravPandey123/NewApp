package com.loc.newsapp.prensentation

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf<Page>(
    Page(
        "Lorem ipsum is simply dummy",
        "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        R.drawable.onboarding1
    ),
    Page(
        "Lorem ipsum is simply dummy",
        "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        R.drawable.onboarding2
    ),
    Page(
        "Lorem ipsum is simply dummy",
        "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        R.drawable.onboarding3
    ),
)

