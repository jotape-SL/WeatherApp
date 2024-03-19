package com.example.weatherapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.Canvas
import androidx.navigation.NavController
import com.example.weatherapp.R

@Composable
fun ConfigPageContent(navController: NavController) {
    WeatherAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ){
                // Header
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    CustomIconButton(
                        painterResource(R.drawable.arrow_right),
                        onClick = { navController.navigate("home") }
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(
                        text ="Configurações",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                //Menu
                //unidades de medição
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                ){
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text ="Unidades de Medição",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    //botoes unidades
                    MenuButtonsUnidades()

                    Spacer(modifier = Modifier.height(20.dp))
                    WhiteLine()

                    //Pessoal
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text ="Pessoal",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    //Bototes pessoal
                    MenuButtonsPessoal()
                }
            }
        }
    }
}

// Estrutura dos botoes de unidades de medição
@Composable
fun MenuButtonUnidadesDetails(icon: Painter, title: String, description: String) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = title,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(text = title, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = description, color = Color.White.copy(alpha = 0.7f))
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}

// display de botoes de unidades de medição
@Composable
fun MenuButtonsUnidades(){
    //temperatura
    MenuButtonUnidadesDetails(
        icon = painterResource(id = R.drawable.thermometer),
        title = "Temperatura",
        description = "Celcius (ºc)"
    )
    //Velocidade
    MenuButtonUnidadesDetails(
        icon = painterResource(id = R.drawable.air),
        title = "Velocidade",
        description = "Quilômetros (km/h)"
    )
    //Chuva
    MenuButtonUnidadesDetails(
        icon = painterResource(id = R.drawable.umbrella),
        title = "Chuva",
        description = "Milímetros (mm)"
    )
    //Altura e distância
    MenuButtonUnidadesDetails(
        icon = painterResource(id = R.drawable.altitude),
        title = "Altitude e distância",
        description = "Metros (m), Quilômetros (km)"
    )
    //Pressão
    MenuButtonUnidadesDetails(
        icon = painterResource(id = R.drawable.pressure),
        title = "Pressão",
        description = "Milibares (mb)"
    )
}

// Estrutura dos botoes Pessoal
@Composable
fun MenuButtonPessoalDetails(icon: Painter, title: String) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = title,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(text = title, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}

// display de botoes de unidades de medição
@Composable
fun MenuButtonsPessoal(){
    //Personaliação
    MenuButtonPessoalDetails(
        icon = painterResource(id = R.drawable.paleta),
        title = "Perosonalização"
    )
    //Segurança
    MenuButtonPessoalDetails(
        icon = painterResource(id = R.drawable.lock),
        title = "Segurança"
    )
    //Notificações
    MenuButtonPessoalDetails(
        icon = painterResource(id = R.drawable.notifications),
        title = "Notificações"
    )
}

//funcao para linha de divisao
@Composable
fun WhiteLine() {
    Surface() {
        Canvas(modifier = Modifier.fillMaxWidth().height(2.dp)) {
            drawLine(
                color = Color.White,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = size.width, y = size.height / 2),
                strokeWidth = 1f
            )
        }
    }
}





