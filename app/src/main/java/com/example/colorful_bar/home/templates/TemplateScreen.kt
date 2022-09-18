package com.example.colorful_bar.home.templates

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.colorful_bar.navigation.Screen

@Composable
fun TemplateScreen() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(templates.size) { index ->
            val template = templates[index]
            Button(
                onClick = {
//                          context.startActivity(TemplatesActivity.newIntent(context, template))
                    Toast.makeText(context, template, Toast.LENGTH_SHORT).show()
                },
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(text = template, modifier = Modifier.padding(8.dp))
            }
        }
    }
}


val templates = listOf(
    "Login",
    "Profiles",
    "On-boarding",
    "Charts",
    "Adding Payment Card",
    "Pin Lock/BioMetric",
    "Empty Screens",
    "Settings",
    "Loaders",
    "Canvas Drawing",
    "Animations",
    "Timer",
    "Clock View",
    "Cascade Menu",
)

@Preview(showBackground = true)
@Composable
fun Prev() {
    TemplateScreen()
}