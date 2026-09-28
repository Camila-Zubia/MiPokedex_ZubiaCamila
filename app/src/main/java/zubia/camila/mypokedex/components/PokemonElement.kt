package zubia.camila.mypokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zubia.camila.mypokedex.R
import zubia.camila.mypokedex.data.bulbasaur
import zubia.camila.mypokedex.domain.Pokemon

@Composable
fun PokemonRow(pokemon: Pokemon){
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Image(painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image",
            Modifier.width(90.dp).padding(10.dp))
        Column(Modifier.fillMaxWidth(0.60f)) {
            Text(pokemon.name)
            Text(pokemon.description, fontSize = 10.sp)
            Row(Modifier.fillMaxWidth(0.60f), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Height: ${pokemon.height}")
                Text("Weight: ${pokemon.weight}")
            }
        }
        Text("${pokemon.num}", modifier = Modifier
            .background(color = colorResource(R.color.green), shape = CircleShape)
            .padding(horizontal = 4.dp, vertical = 2.dp))
    }
}

@Preview(showBackground = true)

@Composable
fun PokemonElementPreview(){
    PokemonRow(bulbasaur)
}