package com.example.colorful_bar.home.templates

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable

class TemplatesActivity : ComponentActivity() {

    private val templateType: String by lazy { intent.getStringExtra(TYPE) ?: "Profiles" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateApp(templateType)
        }
    }


    companion object {
        private const val TYPE = "type"

        fun newIntent(context: Context, templateType: String) =
            Intent(context, TemplatesActivity::class.java).apply {
                putExtra(TYPE, templateType)
            }
    }
}


@Composable
fun TemplateApp(templateType: String) {
    when (templateType) {
        "Profiles" -> ProfileScreen()
        "Login" -> LoginOnboarding()
        "On-boarding" -> OnBoardingScreen { }
        "Charts" -> Charts()
        "Adding Payment Card" -> AddPaymentScreen()
        "Pin Lock/BioMetric" -> PinLockView()
        "Timer" -> TimerDemo()
        "Clock View" -> ClockDemo()
        "Cascade Menu" -> CascadeScreen()
        else -> ComingSoon()
    }
}

@Composable
fun ComingSoon() {
    TODO("Not yet implemented")
}

@Composable
fun CascadeScreen() {
    TODO("Not yet implemented")
}

@Composable
fun ClockDemo() {
    TODO("Not yet implemented")
}

@Composable
fun TimerDemo() {
    TODO("Not yet implemented")
}

@Composable
fun PinLockView() {
    TODO("Not yet implemented")
}

@Composable
fun AddPaymentScreen() {
    TODO("Not yet implemented")
}

@Composable
fun Charts() {
    TODO("Not yet implemented")
}

@Composable
fun OnBoardingScreen(function: () -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun ProfileScreen() {
    TODO("Not yet implemented")
}

@Composable
fun LoginOnboarding() {
    TODO("Not yet implemented")
}
