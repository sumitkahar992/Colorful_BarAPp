package com.example.colorful_bar.screen

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.annotation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.colorful_bar.MainActivity
import com.example.colorful_bar.R
import kotlin.OptIn

@Composable
fun SearchScreen() {
    ZodiacSigns()
}

@Composable
fun ZodiacSigns(
//    list : CardItems ,
//    onClick: (Int) -> Unit,
//    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(
                    items = Data.zodiacList,
                    itemContent = {
                        SimpleCard(
                            date = it.date,
                            name = it.text,
                            border = it.color,
                            image = it.drawable,
                            onClick = {
                                when (it.id) {
                                    it.id -> Toast.makeText(context,
                                        "zodia c - ${it.id}",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }

                        )
                    })
            })


    }
}


data class CardItems(
    val id: Int,
    val date: String,
    val name: String,
    val border: Color,
    val image: Int,
)

object Data {

    val zodiacList = listOf(
        CardItems(
            id = 1,
            date = "July 23 - August 22",
            name = "Leo",
            border = Color.Cyan,
            image = R.drawable.leo
        ),
        CardItems(
            id = 2,
            date = "November 22 - December 21",
            name = "Sagittarius",
            border = Color.Cyan,
            image = R.drawable.sagittarius
        ),
        CardItems(
            id = 3,
            date = "March 21 - April 19",
            name = "Aries",
            border = Color.Cyan,
            image = R.drawable.aries
        ),
        CardItems(
            id = 4,
            date = "May 21 - June 20",
            name = "Gemini",
            border = Color.Cyan,
            image = R.drawable.gemini
        ),
        CardItems(
            id = 5,
            date = "September 23 - October 22",
            name = "Libra",
            border = Color.Cyan,
            image = R.drawable.libra
        ),
        CardItems(
            id = 6,
            date = "January 20 - February 18",
            name = "Aquarius",
            border = Color.Cyan,
            image = R.drawable.aquarius
        ),
        CardItems(
            id = 7,
            date = "February 19 - March 20",
            name = "Pisces",
            border = Color.Cyan,
            image = R.drawable.pisces
        ),
        CardItems(
            id = 8,
            date = "June 21 - July 22",
            name = "Cancer",
            border = Color.Cyan,
            image = R.drawable.cancer
        ),
        CardItems(
            id = 9,
            date = "October 23 - November 21",
            name = "Scorpio",
            border = Color.Cyan,
            image = R.drawable.scorpio
        ),
        CardItems(
            id = 10,
            date = "April 20 - May 20",
            name = "Taurus",
            border = Color.Cyan,
            image = R.drawable.taurus
        ),
        CardItems(
            id = 11,
            date = "December 22 - January 19",
            name = "Capricorn",
            border = Color.Cyan,
            image = R.drawable.capricorn
        ),
        CardItems(
            id = 12,
            date = "August 23 - September 22",
            name = "Virgo",
            border = Color.Cyan,
            image = R.drawable.virgo
        ),


        ).map { DrawableStringPair(it.image, it.name, it.date, it.border, it.id) }

    @SuppressLint("SupportAnnotationUsage")
    data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: String,
        @StringRes val date: String,
        @ColorInt val color: Color,
        @IntegerRes val id: Int,
    )

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleCard(
    image: Int = 0,
    date: String = "",
    name: String = "",
    border: Color = Color.Unspecified,
    onClick: () -> Unit = {},
) {

    Card(
        modifier = Modifier
            .height(220.dp)
            .width(200.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(corner = CornerSize(9.dp)),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 3.dp,
        border = BorderStroke(1.dp, color = border),
        onClick = {
            onClick()
        })

    {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.size(133.dp),
                shape = RectangleShape
            ) {

                Image(
                    painter = painterResource(image),
                    modifier = Modifier,
                    contentDescription = "zodiac",

                    contentScale = ContentScale.FillBounds
                )

            }

            Text(
                text = name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = date,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
            )


        }


    }


}


@Composable
fun ZodiacDetail() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = " ZODIAC DETAIL SCREEN")

    }
}























