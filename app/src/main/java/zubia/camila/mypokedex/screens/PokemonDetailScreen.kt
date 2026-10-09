package zubia.camila.mypokedex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import zubia.camila.mypokedex.components.ListDetail
import zubia.camila.mypokedex.components.PokemonDetail
import zubia.camila.mypokedex.model.data.getPokemonIndex
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.model.domain.Pokemon
import zubia.camila.mypokedex.utilities.getColorByType

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Pokemon, onPreviousClick: () -> Unit, onNextClick: () -> Unit){
    Box(
    ) {
        PokemonDetail(pokemon)
        val currentIndex = getPokemonIndex(pokemon.num)
        ListDetail(currentIndex, pokemonList, onPreviousClick, onNextClick)
    }
}