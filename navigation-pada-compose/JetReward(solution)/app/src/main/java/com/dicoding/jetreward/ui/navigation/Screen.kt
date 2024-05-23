package com.dicoding.jetreward.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Cart : Screen(route = "card")
    object Profile : Screen(route = "profile")
}