package zubia.camila.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import zubia.camila.mypokedex.model.data.CompanionPreferences
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.model.domain.Pokemon
import zubia.camila.mypokedex.model.preferences.PokemonSerializer

class PokemonDetailViewModel(private val companionDataStore: CompanionPreferences): ViewModel() {
    val companion = companionDataStore.pokemonCompanion().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = PokemonSerializer.defaultValue
    )

    fun getPokemonByNumber(number: Int): Pokemon =
        pokemonList.first { it.num == number }

    fun saveCompanion(pokemon: Pokemon){
        viewModelScope.launch {
            companionDataStore.savwCompanion(pokemon)
        }
    }
}
