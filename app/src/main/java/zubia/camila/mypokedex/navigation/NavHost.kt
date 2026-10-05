package zubia.camila.mypokedex.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zubia.camila.mypokedex.screens.MenuPokedexScreen
import zubia.camila.mypokedex.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()
    NavHost(navController, startDestination= PokemonList){
        composable<PokemonList> {
            MenuPokedexScreen(innerPadding, onNavigateToDetail = {id-> navController.navigate(route= PokemonDetail(id))})
        }
        composable<PokemonDetail> {
            PokemonDetailScreen(innerPadding)
        }
    }
}