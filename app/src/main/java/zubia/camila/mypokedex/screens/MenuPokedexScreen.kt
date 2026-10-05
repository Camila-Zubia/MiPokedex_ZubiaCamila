package zubia.camila.mypokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import zubia.camila.mypokedex.components.FavoritesRow
import zubia.camila.mypokedex.components.PokemonCell
import zubia.camila.mypokedex.data.getFavoritePokemons
import zubia.camila.mypokedex.domain.Pokemon
import zubia.camila.mypokedex.navigation.PokemonDetail

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues, favoriteList: List<Pokemon>, allPokemons: List<Pokemon>, onNavigateToDetail: (id:Int)-> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Favoritos", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        }
        item {
            FavoritesRow(favoriteList, onNavigateToDetail)
        }
        item {
            Text("Todos", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
        }
        items(allPokemons.chunked(3)) { rowPokemons ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                rowPokemons.forEach { pokemon ->
                    Box(modifier = Modifier.weight(1f)) {
                        PokemonCell(pokemon)
                    }
                }
                repeat(3 - rowPokemons.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
