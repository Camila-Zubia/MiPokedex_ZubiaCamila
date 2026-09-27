package zubia.camila.mypokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zubia.camila.mypokedex.R.drawable
import zubia.camila.mypokedex.ui.theme.MyPokedexTheme

class PokedexJC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonDetailScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.yellow_back))
    ) {
        Image(
            painter = painterResource(drawable.pokeball),
            contentDescription = null,
            modifier = Modifier
                .size(width = 296.dp, height = 218.dp)
                .align(Alignment.TopEnd)
                .offset(x = 40.dp, y = 80.dp)
                .rotate(32f)
        )

        Image(
            painter = painterResource(drawable.star),
            contentDescription = null,
            modifier = Modifier
                .size(width = 51.dp, height = 53.dp)
                .align(Alignment.TopEnd)
                .padding(top = 24.dp, end = 24.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 32.dp)
                .align(Alignment.TopStart),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Pikachu",
                color = colorResource(R.color.white),
                fontSize = 25.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "#205",
                color = colorResource(R.color.grey),
                fontSize = 20.sp
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = colorResource(R.color.white)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Eléctrico",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 16.dp)
                        .background(
                            color = colorResource(R.color.yellow_back),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp, start = 16.dp, end = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Altura", color = colorResource(R.color.red), fontWeight = FontWeight.Black, fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text("0,4m", color = colorResource(R.color.grey), fontSize = 18.sp)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Peso", color = colorResource(R.color.red), fontWeight = FontWeight.Black, fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text("6,0kg", color = colorResource(R.color.grey), fontSize = 18.sp)
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text("Habilidad", color = colorResource(R.color.red), fontWeight = FontWeight.Black, fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Elec. Estática", color = colorResource(R.color.grey), fontSize = 18.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas.",
                        color = colorResource(R.color.grey),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(drawable.arbok),
                            contentDescription = "Arbok",
                            modifier = Modifier.size(90.dp)
                        )
                        Text("Arbok N° 0024", color = colorResource(R.color.grey), fontSize = 12.sp)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(drawable.raichu),
                            contentDescription = "Raichu",
                            modifier = Modifier.size(100.dp)
                        )
                        Text("Raichu N° 0026", color = colorResource(R.color.grey), fontSize = 12.sp)
                    }
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .size(36.dp)
                        .paint(painterResource(drawable.circle_button))
                ) {
                    Icon(
                        painter = painterResource(drawable.ic_last),
                        contentDescription = "Previous",
                        tint = colorResource(R.color.white)
                    )
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(36.dp)
                        .paint(painterResource(drawable.circle_button))
                ) {
                    Icon(
                        painter = painterResource(drawable.ic_next),
                        contentDescription = "Next",
                        tint = colorResource(R.color.white)
                    )
                }
            }
        }

        Image(
            painter = painterResource(drawable.pikachu),
            contentDescription = "Pikachu",
            modifier = Modifier
                .size(width = 171.dp, height = 228.dp)
                .align(Alignment.TopCenter)
                .offset(y = 100.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyPokedexTheme {
        PokemonDetailScreen()
    }
}