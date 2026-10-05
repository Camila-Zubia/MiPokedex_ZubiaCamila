package zubia.camila.mypokedex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zubia.camila.mypokedex.data.pokemonList
import zubia.camila.mypokedex.domain.Pokemon

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>){
    LazyColumn() {
        items(pokemonList){
            pokemon ->
            PokemonRow(pokemon)

        }
    }

}

@Composable
fun PokemonGrid(pokemonList: List<Pokemon>, onNavigateToDetail: (id:Int)-> Unit){
    LazyVerticalGrid(GridCells.Fixed(3),
        contentPadding = PaddingValues(5.dp, 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        items(pokemonList){
            pokemon ->
            PokemonCell(pokemon)
        }
    }
}
@Composable
fun FavoritesRow(favoritesList: List<Pokemon>, onNavigateToDetail: (id:Int)-> Unit){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoritesList) { pokemon ->
            FavoritePokemon(pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewMenuPokedex(){
    MenuPokedex(pokemonList)
}