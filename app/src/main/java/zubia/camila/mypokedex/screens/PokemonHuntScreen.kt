package zubia.camila.mypokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import zubia.camila.mypokedex.components.PokemonRow
import zubia.camila.mypokedex.ui.theme.Green
import zubia.camila.mypokedex.ui.theme.Psych
import zubia.camila.mypokedex.ui.theme.Purple40
import zubia.camila.mypokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(innerPadding: PaddingValues, viewModel: PokemonViewModel = viewModel(), onNavigateToDetail: (id:Int)-> Unit){
    Spacer(Modifier.size(30.dp))
    Column(Modifier.fillMaxWidth().padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {viewModel.searchPokemon()}){
            Text("Buscar pokemon en la hierva")
        }
        Spacer(Modifier.size(18.dp))
        viewModel.wildPokemon?.let{
            pokemon ->
            Text("Apareció un ${pokemon.name} salvaje", style = MaterialTheme.typography.labelLarge, color= Purple40)
            Image(painterResource(pokemon.image), contentDescription = "${pokemon.name} image", Modifier.size(100.dp))
            Spacer(Modifier.size(15.dp))
            Button(onClick = {viewModel.capturePokemon()}) {
                Text("Capturar a ${pokemon.name}")
            }
        }
        if(viewModel.gonePokemon){
            Text("El pokemon se ha escapado :'(", style= MaterialTheme.typography.labelLarge, color= Color.Magenta)
        }
        if (viewModel.captured){
            Text("Has atrapado al pokemon!! :)", style= MaterialTheme.typography.labelLarge, color= Green)
        }
        Spacer(Modifier.size(20.dp))
        Text("Pokemones capturados", style= MaterialTheme.typography.titleLarge, color= Psych)
        LazyColumn() {
            items(viewModel.capturedPokemon){
                pokemon ->
                PokemonRow(pokemon, onNavigateToDetail)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview(){
    PokemonHuntScreen(PaddingValues(15.dp), viewModel(), onNavigateToDetail = {id -> Unit})
}