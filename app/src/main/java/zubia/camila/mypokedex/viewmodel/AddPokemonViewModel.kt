package zubia.camila.mypokedex.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import zubia.camila.mypokedex.model.data.interfaces.IPokemonRepository
import zubia.camila.mypokedex.model.domain.Pokemon
import zubia.camila.mypokedex.sqlite.PokemonSQLRepository

class AddPokemonViewModel(private val pokemonRepository: PokemonSQLRepository): ViewModel() {
    private val pokemonsMutable = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = pokemonsMutable.asStateFlow()
    var pokemonSaved by mutableStateOf<Boolean>(false)
        private set

    fun loadPokemons(){
        viewModelScope.launch {
            pokemonsMutable.value = pokemonRepository.getPokemons()
        }
    }

    fun savePokemon(num: Int, name: String, type: String, description: String,
                    height: Float, weight: Float, fav: Boolean, ability: String, image: Int){
        val savingPokemon = Pokemon(name, num, type, description, height, weight, fav, ability, image)
        viewModelScope.launch {
            pokemonRepository.addPokemon(savingPokemon)
            pokemonSaved = true
            loadPokemons()
        }
    }
}