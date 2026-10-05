package zubia.camila.mypokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import zubia.camila.mypokedex.data.getFavoritePokemons
import zubia.camila.mypokedex.data.pokemonList
import zubia.camila.mypokedex.screens.MenuPokedexScreen
import zubia.camila.mypokedex.ui.theme.MyPokedexTheme

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPokedexTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MenuPokedexScreen(innerPadding, getFavoritePokemons(), pokemonList)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyPokedexTheme {
        MenuPokedexScreen(PaddingValues(), getFavoritePokemons(), pokemonList)
    }
}