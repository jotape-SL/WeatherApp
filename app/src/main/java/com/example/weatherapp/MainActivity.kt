package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.pages.ConfigPageContent
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.pages.HomePage
import com.example.weatherapp.pages.FavoritosPageContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()
                   NavHost(
                       navController = rememberNavController(),
                       startDestination = "home" ){
                       composable(route = "home"){ HomePage(navController) }
                       composable(route = "favoritos" ){ FavoritosPageContent(navController) }
                       composable(route = "configuracoes"){ ConfigPageContent(navController) }
                   }
                }
            }
        }
    }
}




