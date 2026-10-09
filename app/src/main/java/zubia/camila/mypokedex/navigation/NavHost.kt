package zubia.camila.mypokedex.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import zubia.camila.mypokedex.model.data.getPokemonByNumber
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.screens.MenuPokedexScreen
import zubia.camila.mypokedex.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()
    NavHost(navController, startDestination= PokemonList){
        composable<PokemonList> {
            MenuPokedexScreen(innerPadding, onNavigateToDetail = {id-> navController.navigate(route= PokemonDetail(id))})
        }
        composable<PokemonDetail> {backStackEntry ->
            val pokemonId = backStackEntry.toRoute<PokemonDetail>().id
            val pokemon = getPokemonByNumber(pokemonId)
            val actualPokemon = pokemonList.indexOfFirst { it.num == pokemonId }
            val prevIndex = if (actualPokemon > 0) actualPokemon - 1 else pokemonList.lastIndex
            val nextIndex = if (actualPokemon < pokemonList.lastIndex) actualPokemon + 1 else 0
            val prev = pokemonList[prevIndex]
            val next = pokemonList[nextIndex]
            PokemonDetailScreen(innerPadding, pokemon, onPreviousClick = {
                navController.navigate(route = PokemonDetail(prev.num)) {
                    popUpTo<PokemonDetail> { inclusive = true }
                }
            },
                onNextClick = {
                    navController.navigate(route = PokemonDetail(next.num)) {
                        popUpTo<PokemonDetail> { inclusive = true }
                    }
                })
        }
    }
}