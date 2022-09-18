package com.example.colorful_bar.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.colorful_bar.navigation.Screen
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.colorful_bar.R


@Composable
fun SplashScreen(navController: NavController) {


    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 500)
    )


    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(500)

        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    SplashDesign(alpha = alphaAnimation.value)

}

@Composable
fun SplashDesign(alpha: Float) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.animation),
            contentDescription = null,
            contentScale = ContentScale.None
        )

    }
}