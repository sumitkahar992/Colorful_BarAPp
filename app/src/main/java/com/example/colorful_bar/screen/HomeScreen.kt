package com.example.colorful_bar.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.colorful_bar.navigation.Screen

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        val buttons = buttons

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(32.dp),
            content = {
                items(items = buttons, itemContent = {
                    ButtonStyle(button = it)
                })
            })


    }
}

@Composable
fun ButtonStyle(button: ButtonStyle) {

    val navController = rememberNavController()

    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {


        },
        shape = RoundedCornerShape(35.dp),
        colors = ButtonDefaults.buttonColors(button.color)
    ) {
        Text(text = button.text)

    }
}


data class ButtonStyle(
    val text: String,
    val color: Color,
)

val buttons = listOf(

    ButtonStyle(
        text = "Horizontal ListView",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Grid ListView",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Modifiers ",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Layouts ",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Constraint Layouts",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Motion Layouts",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Advance List",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Custom Fling",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Compose X Android views",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = "Carousel ",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " Dialogs",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),
    ButtonStyle(
        text = " TabsLayout",
        color = Color(0xFF4CAF50)
    ),


    )