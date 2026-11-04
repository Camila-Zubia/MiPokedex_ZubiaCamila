package zubia.camila.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import zubia.camila.mypokedex.model.data.CompanionPreferences
import zubia.camila.mypokedex.model.domain.Pokemon

class PokemonDetailViewModel(private val companionDataStore: CompanionPreferences): ViewModel() {
    fun saveCompanion(pokemon: Pokemon){
        viewModelScope.launch {
            companionDataStore.savwCompanion(pokemon)
        }
    }
}