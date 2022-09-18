package com.example.colorful_bar.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.colorful_bar.home.templates.TemplateScreen
import com.example.colorful_bar.screen.*

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen()
        }

        composable(route = Screen.Search.route) {
            SearchScreen()
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }

        composable(route = Screen.Setting.route) {
            SettingScreen(navController = navController)
        }

        composable(route = Screen.Favourite.route) {
            FavouriteScreen()
        }

        composable(route = Screen.SimpleProfileApp.route) {
            SimpleProfileApp()
        }










        composable(route = Screen.SettingScreen.LazyVerticalGrid.route) {
            LazyVerticalGrid()
        }

        composable(route = Screen.SettingScreen.AlertPage.route) {
            AlertPage()
        }

        composable(route = Screen.SettingScreen.CurrencyTap.route) {
            CurrencyTap()
        }

        composable(route = Screen.SettingScreen.LazyListColumn.route) {
            LazyListColumn()
        }

        composable(route = Screen.SettingScreen.TemplateScreen.route) {
            TemplateScreen()
        }

        composable(route = Screen.SettingScreen.StateCompose.route) {
            ComposeStateScreen()
        }

        composable(route = Screen.SettingScreen.WhyNotCompose.route) {
            WhyNotCompose()
        }


    }


}