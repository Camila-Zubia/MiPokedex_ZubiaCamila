package zubia.camila.mypokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zubia.camila.mypokedex.model.data.bulbasaur
import zubia.camila.mypokedex.utilities.getColorByType


@Composable
fun NumberChip (text: String, modifier: Modifier, colors: Pair<Color, Color>){
    Row(modifier = modifier.padding(5.dp).width(30.dp).height(30.dp).background(colors.first, shape = CircleShape),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Text(text, color = colors.second, style = MaterialTheme.typography.labelSmall)

    }
}

@Preview(showBackground = true)
@Composable
fun ElementPreview(){
    NumberChip(bulbasaur.name, Modifier,
        getColorByType(bulbasaur.type)
    )
}