package com.example.colorful_bar.home.dynamic

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colorful_bar.R
import com.example.colorful_bar.navigation.Screen
import com.example.colorful_bar.screen.HomeScreen


open class Home {


    @Preview(showBackground = true)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HomeScreen() {
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text(text = "c o m p o s e - c o o k b o o k") },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = null)
                        }
                    }
                )
            },
            content = { paddingValues ->
                HomeScreenContent(
                    modifier = Modifier.padding(paddingValues)
                )
            }
        )
    }


    @Composable
    fun HomeScreenContent(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val list = remember { DemoDataProvider.homeScreenListItems }

        Box(modifier = modifier.fillMaxSize()) {
            LazyColumn {
                items(
                    items = list,
                    itemContent = {
                        HomeScreenListView(homeScreenItems = it, context = context)
                    }
                )
            }
        }
    }


    @Composable
    fun HomeScreenListView(
        homeScreenItems: HomeScreenItems, context: Context,
    ) {
        Button(
            onClick = {
//                homeItemClicked(homeScreenItems, context)
                      Toast.makeText(context, "Hello !!", Toast.LENGTH_SHORT).show()

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = homeScreenItems.name,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }


    fun homeItemClicked(homeScreenItems: HomeScreenItems, context: Context) {
        //TODO pass theme to following screens
        val intent = when (homeScreenItems) {


            HomeScreenItems.TabLayout -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

/*            HomeScreenItems.AdvanceLists -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.AndroidViews -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.BottomAppBar -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.BottomSheets -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.Carousel -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.CollapsingAppBar -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.ConstraintsLayout -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.CustomFling -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.Dialogs -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.Layouts -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            is HomeScreenItems.ListView -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.Modifiers -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.MotionLayout -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

            HomeScreenItems.PullRefresh -> {
                DynamicUiActivity.newIntent(context, DynamicUiType.TABS.name)
            }

 */
            HomeScreenItems.AdvanceLists -> TODO()
            HomeScreenItems.AndroidViews -> TODO()
            HomeScreenItems.BottomAppBar -> TODO()
            HomeScreenItems.BottomSheets -> TODO()
            HomeScreenItems.Carousel -> TODO()
            HomeScreenItems.CollapsingAppBar -> TODO()
            HomeScreenItems.ConstraintsLayout -> TODO()
            HomeScreenItems.CustomFling -> TODO()
            HomeScreenItems.Dialogs -> TODO()
            HomeScreenItems.Layouts -> TODO()
            is HomeScreenItems.ListView -> TODO()
            HomeScreenItems.Modifiers -> TODO()
            HomeScreenItems.MotionLayout -> TODO()
            HomeScreenItems.PullRefresh -> TODO()
        }
        context.startActivity(intent)
    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {

}









