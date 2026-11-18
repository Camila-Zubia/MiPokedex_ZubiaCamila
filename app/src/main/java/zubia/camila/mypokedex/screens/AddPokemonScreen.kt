package zubia.camila.mypokedex.screens

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import zubia.camila.mypokedex.R
import zubia.camila.mypokedex.components.ImagePhotoPicker
import zubia.camila.mypokedex.components.PokemonRow
import zubia.camila.mypokedex.model.domain.pokemonTypes
import zubia.camila.mypokedex.ui.theme.Typography
import zubia.camila.mypokedex.viewmodel.AddPokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPokemonScreen(
    innerPadding: PaddingValues,
    addPokemonVM: AddPokemonViewModel,
    onNavigateToDetail: (id: Int) -> Unit
) {
    val number = rememberTextFieldState()
    val name = rememberTextFieldState()
    val type = rememberTextFieldState(pokemonTypes.firstOrNull() ?: "")
    var openType by remember { mutableStateOf(false) }
    val description = rememberTextFieldState()
    val height = rememberTextFieldState()
    val weight = rememberTextFieldState()
    var fav by remember { mutableStateOf(false) }
    val ability = rememberTextFieldState()
    var image: Uri? by remember { mutableStateOf<Uri?>(null) }

    val pokemonList by addPokemonVM.pokemons.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Text("Agregar Pokemon", style = Typography.titleLarge)
            Spacer(Modifier.size(20.dp))
        }

        item {
            TextField(
                state = number,
                label = { Text("Numero de Pokemon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        item {
            TextField(
                state = name,
                label = { Text("Nombre del Pokemon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }

        item {
            ExposedDropdownMenuBox(
                expanded = openType,
                onExpandedChange = { openType = it }
            ) {
                OutlinedTextField(
                    readOnly = true,
                    label = { Text("Selecciona un tipo") },
                    state = type,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = openType) },
                    modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                )
                ExposedDropdownMenu(
                    expanded = openType,
                    onDismissRequest = { openType = false }
                ) {
                    pokemonTypes.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                type.setTextAndPlaceCursorAtEnd(selectionOption)
                                openType = false
                            },
                            text = { Text(selectionOption) }
                        )
                    }
                }
            }
        }

        item {
            TextField(
                state = description,
                label = { Text("Descripción del Pokemon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }

        item {
            TextField(
                state = height,
                label = { Text("Altura del Pokemon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        }

        item {
            TextField(
                state = weight,
                label = { Text("Peso del Pokemon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        }

        item {
            TextField(
                state = ability,
                label = { Text("Habilidad del Pokemon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }

        item {
            //ImagePhotoPicker()
        }

        item {
            Button(onClick = {
                val parsedNumber = number.text.toString().trim().toIntOrNull() ?: return@Button
                val parsedHeight = height.text.toString().trim().toFloatOrNull() ?: 0f
                val parsedWeight = weight.text.toString().trim().toFloatOrNull() ?: 0f
                val parsedImage = image.toString().trim().toIntOrNull() ?: 0

                addPokemonVM.savePokemon(
                    parsedNumber,
                    name.text.toString().trim(),
                    type.text.toString().trim(),
                    description.text.toString().trim(),
                    parsedHeight,
                    parsedWeight,
                    fav,
                    ability.text.toString().trim(),
                    parsedImage
                )
            }) {
                Text("Add Pokemon")
            }
        }

        items(pokemonList) { p ->
            PokemonRow(p, onNavigateToDetail)
        }
    }
}
