package com.example.colorful_bar.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(
    navController: NavController,
    bottomBarState: MutableState<Boolean>
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Profile,
        BottomNavItem.Setting,
        BottomNavItem.Favourite
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                BottomNavigation(
                    backgroundColor = Color.White
                ) {
                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = item.image,
                                    contentDescription = item.title
                                )
                            },
                            label = { Text(text = item.title) },
                            selected = currentRoute == item.route,
                            onClick = {
                                navController.navigate(item.route)
                            },
                            selectedContentColor = Color.Magenta,
                            unselectedContentColor = Color.Black,
                            alwaysShowLabel = false

                        )
                    }


                }
            }


        }
    )


}


@Composable
fun BottomNavigationItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val background =
        if (isSelected) Color.White.copy(alpha = 0.1f) else Color.Transparent
    val contenColor =
        if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = item.image,
                contentDescription = null,
                tint = contenColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title,
                    color = contenColor
                )
            }

        }


    }

}


@Composable
@Preview
fun Prev2() {
    BottomNavigationItem(item = BottomNavItem.Search, isSelected = true) {}
}












