package com.example.colorful_bar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.colorful_bar.home.dynamic.Home
import com.example.colorful_bar.navigation.AppBar
import com.example.colorful_bar.navigation.BottomNavigationBar
import com.example.colorful_bar.navigation.NavGraph
import com.example.colorful_bar.navigation.Screen
import com.example.colorful_bar.ui.theme.Colorful_BarTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            Home().HomeScreen()

            Colorful_BarTheme {
                val bottomBarState = rememberSaveable { mutableStateOf(false) }
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                when (navBackStackEntry?.destination?.route) {
                    Screen.Home.route -> bottomBarState.value = true
                }

                Scaffold(
                    backgroundColor = Color.Gray,
                    topBar = { AppBar() },
                    bottomBar = {
                        BottomNavigationBar(
                            navController = navController,
                            bottomBarState = bottomBarState
                        )
                    }
                ) {
                    NavGraph(navController = navController, paddingValues = it)
                }

            }


//                    MyApp()
//                    LazyGrid()
//                    MainScreen()
//                    AlertPage()


        }
    }


    @Composable
    fun MyApp() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    HorizontalBar(color = Color.Blue)
                    HorizontalBar(color = Color.Red)
                    HorizontalBar(color = Color.Yellow)
                    HorizontalBar(color = Color.Cyan)

                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    VerticalBar(color = Color.Cyan)
                    VerticalBar(color = Color.Yellow)
                    VerticalBar(color = Color.Magenta)
                    VerticalBar(color = Color.Blue)
                }


            }

        }

    }


    @Composable
    fun HorizontalBar(color: Color) {
        Surface(
            modifier = Modifier
                .height(100.dp)
                .width(40.dp),
            color = color
        ) {}
    }

    @Composable
    fun VerticalBar(color: Color) {
        Surface(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp),
            color = color
        ) {}
    }


    @Composable
    fun LazyGrid() {

        Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {

            val state = rememberLazyGridState()

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                state = state
            ) {
                items(50) { index ->

                    val context = LocalContext.current

                    Button(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(10.dp),
                        onClick = {
                            Toast.makeText(context, "clicked-$index", Toast.LENGTH_SHORT).show()
                        },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        Text(text = index.toString(), fontSize = 33.sp)

                    }


                }
            }

        }

    }


    @Composable
    fun MainScreen() {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Gray
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SquareBar(color = Color.Yellow, R.drawable.dark)
                    SquareBar(color = Color.Cyan, R.drawable.light)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SquareBar(color = Color.Green, R.drawable.ui)
                    SquareBar(color = Color.Blue, R.drawable.animation)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SquareBar(color = Color.Magenta, R.drawable.composition)
                    SquareBar(color = Color.Red, R.drawable.tutorial)
                }

            }
        }
    }


    @Composable
    fun SquareBar(color: Color, Image: Int) {
        Surface(
            color = color,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
        ) {
            Image(
                painter = painterResource(id = Image),
                contentDescription = null
            )

        }

    }


    @Composable
    private fun AlertUI(
        dialogState: Boolean,
        onDismissRequest: (dialogState: Boolean) -> Unit,
    ) {

//    val showDialog = remember { mutableStateOf(true) }
//    val showDialog: Boolean
        val context = LocalContext.current
//    val onDismissRequest: () -> Unit

        if (dialogState) {
            AlertDialog(
//            onDismissRequest = { showDialog.value = false },
//            title = { Text(text = "Colorful_Bar") },
//            text = { Text(text = "Do you want to Exit this App") },
                onDismissRequest = { onDismissRequest(dialogState) },
                title = null,
                text = null,

                buttons = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.padding(vertical = 16.dp))

                        Image(
                            painter = painterResource(id = R.drawable.profile_image2),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.padding(vertical = 16.dp))

                        Text(text = "Coding with cat", fontSize = 16.sp, color = Color.White)

                        Text(
                            text = "Subscribe Coding with cat is helpful",
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )

                        Spacer(modifier = Modifier.padding(vertical = 16.dp))

                        Divider(
                            color = Color.Magenta,
                            thickness = 0.6.dp,
                            modifier = Modifier.padding(horizontal = 32.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            TextButton(
                                onClick = {
                                    onDismissRequest(dialogState)
                                    Toast.makeText(context, "nice", Toast.LENGTH_SHORT).show()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Cyan,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Subscribe")
                            }
                            Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                            TextButton(
                                onClick = {
                                    onDismissRequest(dialogState)
                                    Toast.makeText(context, "_-_-_-_-_-_-_--", Toast.LENGTH_SHORT)
                                        .show()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.LightGray,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Cancel")
                            }


                        }

                    }
                },

//            confirmButton = {
//                Button(
//                    onClick = {
//                        showDialog.value = false
//                        Toast.makeText(context,"confirm button click",Toast.LENGTH_SHORT).show()
//                              },
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
//                ) {
//                    Text(text = "Yes", color = Color.Red)
//                }
//            },
//
//            dismissButton = {
//                Button(
//                    onClick = {
//                        showDialog.value = false
//                        Toast.makeText(context,"dissmiss button click",Toast.LENGTH_SHORT).show()
//                              },
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
//                ) {
//                    Text(text = "No", color = Color.Yellow)
//                }
//            },
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                ),

                shape = RoundedCornerShape(16.dp),

                backgroundColor = Color.DarkGray,

                contentColor = Color.White

            )


        }

    }


    @Composable
    fun AlertPage(
        modifier: Modifier = Modifier,
    ) {
        var dialogState by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(20.dp),
                onClick = { dialogState = true })
            { Text(text = "Toggle Dialog") }
        }

        AlertUI(dialogState = dialogState, onDismissRequest = { dialogState = !it })
    }
}





















