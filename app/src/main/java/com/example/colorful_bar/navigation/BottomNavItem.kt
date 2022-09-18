package com.example.colorful_bar.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title : String,
    val image: ImageVector,
    val route: String
){
    object Home : BottomNavItem(
        title = "Home",
        image = Icons.Outlined.Home,
        route = Screen.Home.route
    )
    object Search : BottomNavItem(
        title = "Search",
        image = Icons.Outlined.Search,
        route = Screen.Search.route
    )
    object Profile : BottomNavItem(
        title = "Profile",
        image = Icons.Outlined.Person,
        route = Screen.Profile.route
    )
    object Setting : BottomNavItem(
        title = "Setting",
        image = Icons.Outlined.Settings,
        route = Screen.Setting.route
    )
    object Favourite : BottomNavItem(
        title = "Favourirte",
        image = Icons.Outlined.Favorite,
        route = Screen.Favourite.route
    )
}
