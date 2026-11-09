package zubia.camila.mypokedex.screens

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import zubia.camila.mypokedex.components.ListDetail
import zubia.camila.mypokedex.components.PokemonDetail
import zubia.camila.mypokedex.model.data.getPokemonIndex
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.model.domain.Pokemon
import zubia.camila.mypokedex.utilities.getColorByType
import zubia.camila.mypokedex.viewmodel.PokemonDetailViewModel
import zubia.camila.mypokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Pokemon, onPreviousClick: () -> Unit, onNextClick: () -> Unit, pokemonViewModel: PokemonDetailViewModel){
    Box(
    ) {
        PokemonDetail(pokemon)
        val currentIndex = getPokemonIndex(pokemon.num)
        ListDetail(currentIndex, pokemonList, onPreviousClick, onNextClick)
        Button(onClick = {pokemonViewModel.saveCompanion(pokemon)}){
            Text("Elegir el pokemon")
        }
    }
}