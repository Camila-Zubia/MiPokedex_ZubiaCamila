package zubia.camila.mypokedex.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.sweepGradient
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zubia.camila.mypokedex.data.bulbasaur
import zubia.camila.mypokedex.domain.Pokemon
import zubia.camila.mypokedex.ui.theme.OffWhitte
import zubia.camila.mypokedex.utilities.getColorByType

@Composable
fun PokemonRow(pokemon: Pokemon){
    Row(Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Image(painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image",
            Modifier.width(80.dp).padding(10.dp))
        Column(Modifier.fillMaxWidth(0.70f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(pokemon.name, style = MaterialTheme.typography.labelLarge)
            Text(pokemon.description, fontSize = 10.sp)
            Row(Modifier.fillMaxWidth(0.85f), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Height: ${pokemon.height}", style = MaterialTheme.typography.labelMedium)
                Text("Weight: ${pokemon.weight}", style = MaterialTheme.typography.labelMedium)
            }
        }
        NumberChip(bulbasaur.num.toString(), Modifier, getColorByType(pokemon.type))
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon, onNavigateToDetail: (id:Int)-> Unit) {
    val colors = getColorByType(pokemon.type)
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp).clickable(true, onClick = {onNavigateToDetail(pokemon.num as Int)}), horizontalAlignment = Alignment.CenterHorizontally) {
        Box (modifier = Modifier.padding(15.dp)){
            Box(
                modifier = Modifier
                    .border(
                        BorderStroke(
                            5.dp,
                            sweepGradient(
                                listOf(
                                    colors.first,
                                    OffWhitte,
                                    colors.first,
                                    OffWhitte,
                                    colors.first
                                )
                            )
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(pokemon.image),
                    contentDescription = "${pokemon.name} image",
                    modifier = Modifier.padding(5.dp).width(75.dp)
                )
            }

            NumberChip(
                pokemon.num.toString(),
                Modifier.align(Alignment.BottomEnd).offset(x = 15.dp, y = 15.dp),
                getColorByType(pokemon.type))
        }
        Text(pokemon.name, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun PokemonCell(pokemon: Pokemon){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box (){
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painterResource(pokemon.image),
                    contentDescription = "${pokemon.name} image",
                    modifier = Modifier.padding(10.dp).size(150.dp)
                )
            }

            NumberChip(
                pokemon.num.toString(),
                Modifier.align(Alignment.TopEnd),
                getColorByType(pokemon.type))
        }
        Text(pokemon.name, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview(showBackground = true)

@Composable
fun PokemonElementPreview(){
    //PokemonRow(bulbasaur)
    //FavoritePokemon(bulbasaur)
    PokemonCell(bulbasaur)
}