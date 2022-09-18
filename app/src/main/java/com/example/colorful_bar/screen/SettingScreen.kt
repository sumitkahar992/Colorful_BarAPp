package com.example.colorful_bar.screen

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorful_bar.MainActivity
import kotlin.random.Random
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.colorful_bar.BuildConfig
import com.example.colorful_bar.R
import com.example.colorful_bar.home.templates.TemplatesActivity
import com.example.colorful_bar.navigation.Screen

@Composable
fun SettingScreen(navController: NavController) {

    var dialogState by remember { mutableStateOf(false) }
    val count = rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CounterApp(count)


        Button(onClick = {
            dialogState = true
        })
        { Text(text = "Alert - Dialog") }


        AlertUI(dialogState = dialogState, onDismissRequest = { dialogState = !it })


        Button(onClick = {
            navController.navigate(Screen.SettingScreen.LazyVerticalGrid.route)
        })
        { Text(text = "Lazy - Vertical - Grid") }


        Button(onClick = {
            navController.navigate(Screen.SettingScreen.CurrencyTap.route)
        }) {
            Text(text = "Currency - Tapp")
        }



        Button(onClick = {
            navController.navigate(Screen.SettingScreen.LazyListColumn.route)
        }) {
            Text(text = "Lazy -List -Column")
        }


        Button(onClick = {
            navController.navigate(Screen.SettingScreen.TemplateScreen.route)
        }) {
            Text(text = "TEMPLATE - SCREEN")
        }


        Button(onClick = {
            navController.navigate(Screen.SettingScreen.StateCompose.route)
        }) {
            Text(text = "State_Compose")
        }

        Button(onClick = {
            navController.navigate(Screen.SettingScreen.WhyNotCompose.route)
        }) {
            Text(text = "Why-NOt-COmpose")
        }


    }
}

@Composable
private fun CounterApp(count: MutableState<Int>) {
    Row {

        Card(
            modifier = Modifier
                .size(80.dp, 80.dp)
                .clickable {
                    count.value++
                },
            shape = CircleShape,

            ) {
            Text(
                text = "+",
                modifier = Modifier,
                fontSize = 50.sp,
                textAlign = TextAlign.Center
            )
        }


        Spacer(modifier = Modifier.size(20.dp))

        Text(
            text = "${count.value}",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            color = Color(
                red = Random.nextInt(0, 255),
                green = Random.nextInt(0, 255),
                blue = Random.nextInt(0, 255)
            )
        )

        Spacer(modifier = Modifier.size(20.dp))

        Card(
            modifier = Modifier
                .size(80.dp, 80.dp)
                .clickable {
                    count.value--
                },
            shape = CircleShape,

            ) {
            Text(
                text = "-",
                modifier = Modifier,
                fontSize = 50.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}


@Composable
fun LazyVerticalGrid() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val state = rememberLazyGridState()

        androidx.compose.foundation.lazy.grid.LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            state = state,
        ) {
            items(100) { index ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .aspectRatio(1f),
                    backgroundColor = Color(
                        red = Random.nextInt(0, 255),
                        blue = Random.nextInt(0, 255),
                        green = Random.nextInt(0, 255)
                    )
                )
                {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Text(text = index.toString(), fontSize = 25.sp)
                    }
                }
            }

        }
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
            onClick = {
                dialogState = true
            })
        { Text(text = "Toggle Dialog") }
    }

    AlertUI(dialogState = dialogState, onDismissRequest = { dialogState = !it })
}


@Composable
fun CurrencyTap() {

    val moneyCounter = remember {
        mutableStateOf(0)
    }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF585858)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "$${moneyCounter.value} k", style = TextStyle(
                    color = Color.White,
                    fontSize = 31.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            Spacer(modifier = Modifier.height(80.dp))


            CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                moneyCounter.value = newValue
            }

            Spacer(modifier = Modifier.height(80.dp))

            if (moneyCounter.value > 1500) {
                Text(
                    text = "Lots of Money. !", style = TextStyle(
                        color = Color.Cyan,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            } else {
                Text(
                    text = "gonna Be Super Rich $$$$",
                    style = TextStyle(
                        color = Color.Magenta,
                        fontSize = 16.sp,
                    )
                )
            }

        }
    }

}

@Composable
fun CreateCircle(moneyCounter: Int = 0, updatMoneyCounter: (Int) -> Unit) {


    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(133.dp)
            .clickable {
                updatMoneyCounter(moneyCounter + 100)
//                moneyCounter.value += 1
//                Log.d("moneyCounter", "$moneyCounter")
            },
        shape = CircleShape,
        elevation = 4.dp
    )

    {
        Box(
            modifier = Modifier, contentAlignment = Alignment.Center
        )
        { Text(text = "Tap") }

    }
}


@Composable
fun LazyListColumn() {

    val list = listOf("Red", "Blue", "Green", "Purple")

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            Card(backgroundColor = Color(0xFFFFC107), elevation = 4.dp) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    Alignment.Center
                ) {
                    Text(text = "Yellow", style = MaterialTheme.typography.h5, color = Color.White)
                }

            }
        }


        items(list) { item ->
            Card(backgroundColor = Color(0xFF03A9F4), elevation = 4.dp) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    Alignment.Center
                ) {
                    Text(text = item, style = MaterialTheme.typography.h5, color = Color.White)
                }

            }
        }

        item {
            Card(backgroundColor = Color(0xFFE91E63), elevation = 4.dp) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    Alignment.Center
                ) {
                    Text(text = "Pink", style = MaterialTheme.typography.h5, color = Color.White)
                }

            }
        }
        items(20) { index ->
            Card(backgroundColor = Color(0xFF337A35), elevation = 4.dp) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    Alignment.Center
                ) {
                    Text(
                        text = "${index + 1}",
                        style = MaterialTheme.typography.h5,
                        color = Color.White
                    )
                }

            }
        }


    }
}


@Composable
fun ComposeStateScreen() {
    MyApp {
//      ComposeState()
        StateExample()
    }

}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    content()
}


@Composable
fun ComposeState() {

    var count by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier,
            text = count.toString(),
            fontSize = 55.sp,
            fontFamily = FontFamily.Monospace
        )

        Button(onClick = {
            count++
        }) {
            Text(text = "Click $count times")
        }

    }
}


//var counter by mutableStateOf(0)

@Composable
fun StateExample() {

    var counter by remember { mutableStateOf(0) }
    var counter1 by remember { mutableStateOf(2) }
    var counter2 by remember { mutableStateOf(4) }
    var counter3 by remember { mutableStateOf(6) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Hello Devs")

        Component1 {
            counter++
            counter1 += 2
            counter2 += 4
            counter3 += 6
        }

        Component2(counter)
        Component2(counter1)
        Component2(counter2)
        Component2(counter3)

    }
}

@Composable
fun Component1(onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = onClick) {
            Text(text = "click me")
        }

    }
}

@Composable
fun Component2(counter: Int) {

    Text(text = "value of count = $counter")
}





data class MenuItem(
    val name: String,
    @DrawableRes val icon: Int,
    val color: Color
)

private val menuItems = listOf(
    MenuItem(
        name = "Animations",
        icon = R.drawable.animation,
        color = Color.Yellow

    ),
    MenuItem(
        name = "Compositions",
        icon = R.drawable.composition,
        color = Color.Red

    ),
    MenuItem(
        name = "UIs",
        icon = R.drawable.ui,
        color = Color.Cyan

    ),
    MenuItem(
        name = "Tutorials",
        icon = R.drawable.tutorial,
        color = Color.Green
    )

    )

@Composable
fun WhyNotCompose(
    navigate: (Screen) -> Unit = {},
    turnOnDarkMode: (Boolean) -> Unit = {}
) {
    val context = LocalContext.current

    val isDark = !MaterialTheme.colors.isLight

    val (darkModeState, onDarkModeStateChange) = remember { mutableStateOf(isDark) }

    Scaffold()
    { padding ->

        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f)) {
                androidx.compose.foundation.lazy.grid.LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(24.dp, 8.dp, 24.dp, 8.dp)

                ) {
                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = 16.dp,
                                        top = 32.dp,
                                        end = 16.dp
                                    )
                                    .fillMaxWidth(),
                                text = stringResource(id = R.string.app_name),
                                style = MaterialTheme.typography.h5,
                                fontFamily = FontFamily.Monospace,
                                textAlign = TextAlign.Center,
                            )

                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = 16.dp,
                                        top = 4.dp,
                                        end = 16.dp,
                                        bottom = 32.dp
                                    ),
                                text = "Version ${BuildConfig.VERSION_NAME}",
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                            )

                        }
                    }
                    item {
                        ModuleButton(
                            name = if (isDark) "Dark Mode" else "Light Mode",
                            icon = if (isDark) R.drawable.dark else R.drawable.light,
                            color = Color.LightGray,
                            onClick = {

                                Toast.makeText(context, "Hello compose", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }

                    items(menuItems) { menu ->
                        ModuleButton(
                            name = menu.name,
                            icon = menu.icon,
                            color = menu.color,
                            onClick = {


                            }
                        )

                    }


                }
            }
        }

    }


}

@Composable
fun ModuleButton(
    name: String,
    @DrawableRes icon: Int,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(
                spotColor = color,
                elevation = 32.dp,
                ambientColor = color,
            ),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = color
        ),
        onClick = onClick,
        contentPadding = PaddingValues(8.dp),
        elevation = null
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = LocalContentColor.current
            )
            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = name,
                color = LocalContentColor.current,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 17.sp
            )
        }
    }
}


