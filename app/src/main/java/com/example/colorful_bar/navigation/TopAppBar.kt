package com.example.colorful_bar.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.colorful_bar.R
import com.example.colorful_bar.ui.theme.Grey200

@Preview(showBackground = true)
@Composable
fun AppBar() {
    TopAppBar(
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = null
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = null
                        )
                    }
                }

            }
        },
        backgroundColor = Color.White
    )
}