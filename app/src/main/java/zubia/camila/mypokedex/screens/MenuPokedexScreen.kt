package zubia.camila.mypokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import zubia.camila.mypokedex.R
import zubia.camila.mypokedex.components.FavoritesRow
import zubia.camila.mypokedex.components.MenuPokedex
import zubia.camila.mypokedex.components.PokemonGrid
import zubia.camila.mypokedex.components.PokemonRow
import zubia.camila.mypokedex.model.data.getFavoritePokemons
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.ui.theme.Blue
import zubia.camila.mypokedex.ui.theme.Green
import zubia.camila.mypokedex.ui.theme.LightBlue
import zubia.camila.mypokedex.ui.theme.LightGreen

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues, onNavigateToDetail: (id:Int)-> Unit) {
    var grid by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row() {
            Switch(checked = grid, onCheckedChange = {grid = it}, colors = SwitchDefaults.colors(
                checkedThumbColor = Green,
                checkedTrackColor = LightGreen,
                uncheckedThumbColor = Blue,
                uncheckedTrackColor = LightBlue,
                uncheckedBorderColor = Color.Transparent
            ),
            thumbContent = if (grid){
                {
                    Icon(
                        painterResource(R.drawable.ic_grid),
                        contentDescription = "grid icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize))
                }
            }else{
                {
                    Icon(
                        painterResource(R.drawable.ic_rows),
                        contentDescription = "list icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize))
                }
            })}
        Text("Favoritos", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)
        if (grid) {
            PokemonGrid(pokemonList, onNavigateToDetail)
        } else {
            MenuPokedex(pokemonList, onNavigateToDetail)
        }
    }
}

