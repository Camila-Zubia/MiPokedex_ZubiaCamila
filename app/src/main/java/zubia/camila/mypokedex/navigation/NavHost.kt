package zubia.camila.mypokedex.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import zubia.camila.mypokedex.components.TopNavBar
import zubia.camila.mypokedex.model.data.Users
import zubia.camila.mypokedex.model.data.getPokemonByNumber
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.screens.LoginScreen
import zubia.camila.mypokedex.screens.MenuPokedexScreen
import zubia.camila.mypokedex.screens.PokemonDetailScreen
import zubia.camila.mypokedex.screens.PokemonHuntScreen
import zubia.camila.mypokedex.viewmodel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues, usersViewModel: UserViewModel){
    val topView = Login
    val navController = rememberNavController()
    val navigateToMenu= {
        navController.navigate(PokemonList)
    }
    val show = true
    Scaffold(
        topBar = {
            if (show) {
                TopNavBar(navController)
            }
        }
    ){innerPadding ->
        NavHost(navController, startDestination= Login){
            composable<Login> {
                LoginScreen(innerPadding, onNavigateToMenu= navigateToMenu, viewModel = usersViewModel)
            }
            composable<PokemonList> {
                MenuPokedexScreen(innerPadding,
                    onNavigateToDetail = {id-> navController.navigate(route= PokemonDetail(id))},
                    onNavigateToHunt = {navController.navigate(route = PokemonHunt)})
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
            composable<PokemonHunt> {
                PokemonHuntScreen(innerPadding, onNavigateToDetail = {id-> navController.navigate(route= PokemonDetail(id))})
            }
        }
    }
}