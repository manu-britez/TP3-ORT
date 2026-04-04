package com.example.challenge1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.challenge1.ui.theme.Challenge1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge1Theme {
                var currentScreen by remember { mutableStateOf("welcome") }

                when (currentScreen) {
                    "welcome" -> WelcomeScreen(
                        onLoginClick = { currentScreen = "login" },
                        onRegisterClick = { currentScreen = "register" }
                    )
                    "login" -> LoginScreen(
                        onBackClick = { currentScreen = "welcome" }
                    )
                    "register" -> RegisterScreen(
                        onBackClick = { currentScreen = "welcome" }
                    )
                }
            }
        }
    }
}
