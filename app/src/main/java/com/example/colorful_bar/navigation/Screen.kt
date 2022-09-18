package com.example.colorful_bar.navigation


sealed class Screen(val route: String) {

    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
    object Profile : Screen("profile_screen")
    object Setting : Screen("setting_screen")
    object Favourite : Screen("favourite_screen")


    //    Setting Screen
    sealed class SettingScreen(val route: String) {
        object LazyVerticalGrid : SettingScreen("lazy_vertical_grid")
        object AlertPage : SettingScreen("alert_page")
        object CurrencyTap : SettingScreen("currency_tap")
        object LazyListColumn : SettingScreen("lazy_list_column")

        object TemplateScreen : SettingScreen("template_screen")
        object StateCompose : SettingScreen("state_compose")
        object WhyNotCompose : SettingScreen("why_not_compose")

    }


    //    Home Screen
    sealed class HomeScreen(val route: String){

    }














}

