package com.example.colorful_bar.home.dynamic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.colorful_bar.home.tabslayout.TabLayout


class DynamicUiActivity : ComponentActivity() {

    private val dynamicUiType: String by lazy {
        intent?.getStringExtra(TYPE) ?: DynamicUiType.TABS.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicUiWrapper(uiType = dynamicUiType) {

            }

        }
    }


    companion object {
        const val TYPE = "type"
        fun newIntent(context: Context, dynamicUiType: String) =
            Intent(context, DynamicUiType::class.java).apply {
                putExtra(TYPE, dynamicUiType)
            }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicUiWrapper(uiType: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = uiType) },
                navigationIcon = {
                    IconButton(onClick = { onBack }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null)
                    }
                }
            )
        },
        content = { paddingValues ->
            DynamicUiScreen(
                uiType = uiType,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}


@Composable
fun DynamicUiScreen(
    uiType: String,
    modifier: Modifier = Modifier,
) {
    // We setup a base activity and we will change content depending upon ui type so
    // we don't have to create Activity for every feature showcase
    Box(modifier = modifier) {
        when (uiType) {
            DynamicUiType.TABS.name -> {
                TabLayout()
            }
/*            DynamicUiType.BOTTOMSHEET.name -> {
                TabLayout()
            }
            DynamicUiType.LAYOUTS.name -> {
                TabLayout()
            }
            DynamicUiType.CONSTRAINTLAYOUT.name -> {
                TabLayout()
            }
            DynamicUiType.CAROUSELL.name -> {
                TabLayout()
            }
            DynamicUiType.MODIFIERS.name -> {
                TabLayout()
            }
            DynamicUiType.ANDROIDVIEWS.name -> {
                TabLayout()
            }
            DynamicUiType.PULLREFRESH.name -> {
                TabLayout()
            }
            DynamicUiType.MOTIONLAYOUT.name -> {
                TabLayout()
            }

 */
        }
    }
}
































