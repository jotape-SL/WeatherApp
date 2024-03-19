package com.example.weatherapp.pages

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.delay
import java.util.Calendar
import java.util.Locale
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavController
import com.example.weatherapp.R


@Composable
fun HomePage(navController: NavController) {
    var selectedDay by remember { mutableStateOf("Hoje") }
    WeatherAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            // Imagem de fundo
            Image(
                painter = painterResource(id = R.drawable.bg_pic),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopStart
            )

            // Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Row {
                    // Botões do header
                    CustomIconButton(
                        painterResource(R.drawable.hamb_menu),
                        onClick = { navController.navigate("configuracoes")}
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    CustomIconButton(
                        painterResource(R.drawable.star),
                        onClick = { navController.navigate("favoritos") }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    CustomIconButton(
                        painterResource(R.drawable.search),
                        onClick = { /* Ação para a busca */ }
                    )
                }

                // Temperatura, local e hora
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "18ºc",
                        fontSize = 93.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "São Paulo",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Clock()
                }

                // Dias de previsão
                Spacer(modifier = Modifier.height(60.dp))
                Row {
                    ClickableText(
                        text = "Hoje",
                        isSelected = selectedDay == "Hoje",
                        onClick = { selectedDay = "Hoje" }
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    ClickableText(
                        text = "Amanhã",
                        isSelected = selectedDay == "Amanhã",
                        onClick = { selectedDay = "Amanhã" }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ClickableText(
                        text = "Previsão da semana",
                        isSelected = selectedDay == "Previsão da semana",
                        onClick = { selectedDay = "Previsão da semana" }
                    )
                }

                // Horas e temperaturas
                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    // Cards secundários
                    repeat(2) {
                        SecondaryWeatherCard()
                    }

                    // Card principal
                    PrimaryWeatherCard()

                    // Cards secundários
                    repeat(2) {
                        SecondaryWeatherCard()
                    }
                }

                // Porcentagens adicionais de clima
                Spacer(modifier = Modifier.height(70.dp))
                WeatherDetails()

                // Footer
                Footer()
            }
        }
    }
}

// Função para os botões do header
@Composable
fun CustomIconButton(
    painter: Painter,
    onClick: () -> Unit
) {
    Icon(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clickable(onClick = onClick),
        tint = Color.White
    )
}

// Função para exibir o horário atual
@Composable
fun Clock() {
    val currentTime = remember { mutableStateOf(getCurrentTime()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(60000) // Espera 1 minuto
            currentTime.value = getCurrentTime() // Atualiza o tempo
        }
    }

    Text(
        text = currentTime.value,
        fontSize = 16.sp,
        color = Color.White
    )
}

// Função para obter o horário atual
private fun getCurrentTime(): String {
    val calendar = Calendar.getInstance()
    val dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    return "$dayOfWeek $hour:$minute"
}

// Função para a seleção de data de previsão
@Composable
fun ClickableText(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val textColor = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f)
    Text(
        text = text,
        fontSize = 16.sp,
        color = textColor,
        modifier = Modifier.clickable(onClick = onClick)
    )
}

// Componente para os cards secundários
@Composable
fun SecondaryWeatherCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "10:00",
            color = Color.White
        )
        Surface(
            modifier = Modifier
                .height(60.dp)
                .width(45.dp)
                .border(1.dp, Color.White, RoundedCornerShape(8.dp)),
            color = Color.Transparent,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.partly_cloudy_day),
                    contentDescription = "Partly Cloudy",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 16.dp),
                    alignment = Alignment.TopCenter,
                )
                Text(
                    text = "18ºc",
                    color = Color.White
                )
            }
        }
    }
}

// Componente para o card principal
@Composable
fun PrimaryWeatherCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "10:00",
            color = Color.White
        )
        Card(
            modifier = Modifier
                .height(72.dp)
                .width(50.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sunny),
                    contentDescription = "Sunny",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 16.dp),
                    alignment = Alignment.TopCenter
                )
                Text(text = "18ºc")
            }
        }
    }
}

// Componente para as porcentagens adicionais de clima
@Composable
fun WeatherDetails() {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Umidade
        WeatherDetailItem(
            painterResource(id = R.drawable.humidity_high),
            "Umidade",
            "64%"
        )
        // Precipitação
        WeatherDetailItem(
            painterResource(id = R.drawable.rainy),
            "Precipitação",
            "87%"
        )
        // Ventos
        WeatherDetailItem(
            painterResource(id = R.drawable.air),
            "Ventos",
            "10km/h"
        )
    }
}

// Componente para cada item de detalhe de clima
@Composable
fun WeatherDetailItem(
    icon: Painter,
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            contentDescription = label,
            modifier = Modifier
                .size(70.dp)
                .padding(top = 16.dp),
            painter = icon,
            alignment = Alignment.Center
        )
        Row {
            Text(
                text = label,
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = value,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}

// Componente para o footer
@Composable
fun Footer() {
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Mais Detalhes",
            color = Color.White,
            fontSize = 12.sp
        )
        Image(
            painter = painterResource(id = R.drawable.arrow_back_ios),
            contentDescription = "Arrow Down",
            modifier = Modifier
                .size(30.dp)
                .padding(top = 16.dp),
            alignment = Alignment.TopCenter,
        )
    }
}