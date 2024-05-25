package com.dicoding.jetreward.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Cart : Screen(route = "card")
    object Profile : Screen(route = "profile")
    object DetailReward : Screen(route = "home{rewardId}"){
        fun createRoute(rewardId: Long) = "home/$rewardId"
    }
}