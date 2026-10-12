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
    var capturedPOkemon by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePOkemon by mutableStateOf(false)
        private set

    fun searchPokemon(){
        wildPokemon = pokemonList.random()
    }

    fun capturePokemon(){
        wildPokemon?.let {
            var isCaptured = (1..2).random()
            if(isCaptured == 1){
                capturedPOkemon = capturedPOkemon + it
                gonePOkemon = false
                wildPokemon = null
            }else{
                gonePOkemon = true
                wildPokemon = null
            }
        }
    }
}