package zubia.camila.mypokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zubia.camila.mypokedex.model.domain.pokemonTypes
import zubia.camila.mypokedex.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPokemonScreen(innerPadding: PaddingValues){
    var number= remember { TextFieldState() }
    var name = remember { TextFieldState()}
    var type  = remember { TextFieldState()}
    val textFieldState = rememberTextFieldState(pokemonTypes[0])
    var openType by remember { mutableStateOf(false) }
    var description = remember { TextFieldState() }
    var height = remember { TextFieldState() }
    var weight = remember { TextFieldState() }
    var fav = remember { TextFieldState() }
    var ability = remember { TextFieldState() }
    var image = remember { TextFieldState() }


    Column(Modifier.fillMaxSize().padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Text("Agregar Pokemon", style= Typography.titleLarge)
        Spacer(Modifier.size(20.dp))
        TextField(
            state = number,
            label={
                Text("Numero de Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            state = name,
            label={
                Text("Nombre del Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        ExposedDropdownMenuBox(expanded = openType, onExpandedChange = {openType = it}) {
            OutlinedTextField(
                readOnly = true,
                label={ Text("Selecciona un tipo") },
                state= type,
                trailingIcon= { ExposedDropdownMenuDefaults.TrailingIcon(expanded = openType) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = openType, onDismissRequest = { openType = false }) {
                pokemonTypes.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            textFieldState.setTextAndPlaceCursorAtEnd(selectionOption)
                            openType = false
                        },
                        text = { Text(selectionOption) }
                    )
                }
            }
        }
        TextField(
            state = description,
            label={
                Text("Descripción del Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        TextField(
            state = height,
            label={
                Text("Altura del Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            state = weight,
            label={
                Text("Peso del Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            state = ability,
            label={
                Text("Habilidad del Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        TextField(
            state = image,
            label={
                Text("Imagen del Pokemon")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddPokemon(){
    AddPokemonScreen(PaddingValues(20.dp))
}