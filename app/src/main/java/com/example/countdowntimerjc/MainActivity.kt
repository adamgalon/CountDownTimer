package com.example.countdowntimerjc

import android.os.Bundle
import androidx.navigation.NavController

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countdowntimerjc.ui.HomeScreen
import com.example.countdowntimerjc.ui.Statistics
import com.example.countdowntimerjc.ui.theme.CountDownTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountDownTheme {
                MyApp()
            }
        }
    }
}
//color = MaterialTheme.colors.background


@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("statistics") { Statistics()}
    }
}


@Preview("Light Theme")
@Composable
fun LightPreview() {
    CountDownTheme {
        MyApp()
    }
}

@Preview("Dark Theme")
@Composable
fun DarkPreview() {
    CountDownTheme(darkTheme = true) {
        MyApp()
    }
}


