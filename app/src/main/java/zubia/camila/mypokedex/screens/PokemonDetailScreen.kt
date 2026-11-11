package zubia.camila.mypokedex.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import zubia.camila.mypokedex.components.ListDetail
import zubia.camila.mypokedex.components.PokemonDetail
import zubia.camila.mypokedex.model.data.getPokemonIndex
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.model.domain.Pokemon
import zubia.camila.mypokedex.viewmodel.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(
    innerPadding: PaddingValues,
    pokemon: Pokemon,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    pokemonViewModel: PokemonDetailViewModel
) {
    val companion by pokemonViewModel.companion.collectAsStateWithLifecycle()
    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        PokemonDetail(pokemon, companion.num == pokemon.num) {
            pokemonViewModel.saveCompanion(pokemon)
        }
        val currentIndex = getPokemonIndex(pokemon.num)
        ListDetail(currentIndex, pokemonList, onPreviousClick, onNextClick)
    }
}
