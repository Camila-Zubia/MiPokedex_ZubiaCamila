package zubia.camila.mypokedex.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.model.domain.Pokemon

class PokemonViewModel : ViewModel(){
    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set
    var capturedPokemon by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePokemon by mutableStateOf(false)
        private set

    var captured by mutableStateOf(false)
        private set

    fun searchPokemon(){
        wildPokemon = pokemonList.random()
        captured = false
        gonePokemon = false
    }

    fun capturePokemon(){
        wildPokemon?.let {
            var isCaptured = (1..2).random()
            if(isCaptured == 1){
                capturedPokemon = capturedPokemon + it
                gonePokemon = false
                wildPokemon = null
                captured = true
            }else{
                gonePokemon = true
                wildPokemon = null
                captured = false
            }
        }
    }
}