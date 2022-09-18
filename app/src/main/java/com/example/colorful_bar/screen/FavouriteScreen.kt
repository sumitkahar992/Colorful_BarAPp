package com.example.colorful_bar.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import com.example.colorful_bar.R
import com.example.colorful_bar.ui.theme.Colorful_BarTheme

@Composable
fun FavouriteScreen() {

    Scaffold(
        topBar = { Appbar() }
    ) { padding ->
        MyApp(modifier = Modifier.padding(padding))
    }

}


@Composable
private fun Appbar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .clickable { }
                    .padding(horizontal = 25.dp)
            )
        },

        title = {
            Text(text = "Jet NEws APP")
        },

        backgroundColor = MaterialTheme.colors.surface
    )
}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(stringResource(id = R.string.placeholde_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background
        ),
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
}


@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(7.dp)
    )
    {
        Image(
            painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )

        Text(
            stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}


@Composable
fun FavouriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(6.dp)
    ) {
        Row(
            modifier = Modifier.width(192.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )

            Text(
                stringResource(id = text),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }

}


//@Preview(showBackground = true)
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),

        ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun FavouriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp)

    ) {
        items(favouriteCollectionData) { item ->
            FavouriteCollectionCard(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(id = title).uppercase(java.util.Locale.getDefault()),
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)

        )
        content()

    }


}


//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,

    ) {
    Column(
        modifier
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier.height(16.dp))

        Divider(startIndent = 20.dp, thickness = 1.dp, color = Color(0xFF9C27B0))

        SearchBar(modifier.padding(horizontal = 16.dp))

        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }

        Divider(startIndent = 50.dp, thickness = 2.dp, color = Color(0xFF03A9F4))

        HomeSection(title = R.string.favorite_collections) {
            FavouriteCollectionsGrid()
        }

        Divider(startIndent = 80.dp, thickness = 1.5.dp, color = Color(0xFFF13575))

        Spacer(modifier.height(16.dp))

    }
}


@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(Icons.Default.Home, contentDescription = null)
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_home))
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_profile))
            }
        )
    }
}


@Composable
fun MyApp(modifier: Modifier) {

    Scaffold(
        bottomBar = { BottomNavigation() }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}


private val alignYourBodyData = listOf(
    R.drawable.dummbell to R.string.dumbbell,
    R.drawable.yoga to R.string.yoga,
    R.drawable.meditate to R.string.meditate,
    R.drawable.pushup to R.string.pushUp,
    R.drawable.running to R.string.running,
    R.drawable.squat to R.string.squat,
    R.drawable.workout to R.string.workout

).map { DrawableStringPair(it.first, it.second) }


private val favouriteCollectionData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down,

    ).map { DrawableStringPair(it.first, it.second) }


private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    Colorful_BarTheme() {
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}
