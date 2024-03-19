package com.example.weatherapp.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.Canvas
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import com.example.weatherapp.R

@Composable
fun FavoritosPageContent(navController: NavController) {
    WeatherAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    CustomIconButton(
                        painterResource(R.drawable.arrow_right),
                        onClick = {navController.navigate("home") }
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(
                        text = "Favoritos",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                //localiazação atual
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text ="Localização Atual",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(20.dp))
                //Card de localiazação atual
                CardFavoritosDetails(
                    hora = "18:56",
                    cidade = "São Paulo",
                    estado = "São Paulo",
                    pais = "Brasil",
                    icon = painterResource(id = R.drawable.sunny_white),
                    temp = "18 ºc",
                    bgCard = painterResource(id = R.drawable.bg_pic)
                )

                // Favoritos
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text ="Favoritos",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(20.dp))
                CardFavoritosDetails(
                    hora = "18:56",
                    cidade = "Curitiba",
                    estado = "paraná",
                    pais = "Brasil",
                    icon = painterResource(id = R.drawable.cloudy_snowing),
                    temp = "10 ºc",
                    bgCard = painterResource(id = R.drawable.everest)
                )
                CardFavoritosDetails(
                    hora = "18:56",
                    cidade = "Moscow",
                    estado = "Oblast",
                    pais = "Rússia",
                    icon = painterResource(id = R.drawable.cloudy_snowing),
                    temp = "10 ºc",
                    bgCard = painterResource(id = R.drawable.everest)
                )
            }
        }
    }
}

// Estrutura do card favoritos
@Composable
fun CardFavoritosDetails(
    hora: String,
    cidade: String,
    estado: String,
    pais: String,
    icon: Painter,
    temp: String,
    bgCard: Painter
){
    Box(
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = bgCard,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .alpha(0.5f),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.TopStart
    )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Text(
                    text = hora,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = cidade,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp
                )
                Text(
                    text = "${estado}, ${pais}",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = icon,
                    contentDescription = "Icone de tempo",
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = temp,
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
    Spacer(modifier = Modifier.height(10.dp))
}