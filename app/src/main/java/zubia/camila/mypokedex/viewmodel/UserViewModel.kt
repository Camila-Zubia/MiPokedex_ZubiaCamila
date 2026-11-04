package zubia.camila.mypokedex.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import zubia.camila.mypokedex.model.data.CompanionPreferences
import zubia.camila.mypokedex.model.data.Users
import zubia.camila.mypokedex.model.data.bulbasaur
import zubia.camila.mypokedex.model.domain.Pokemon
import zubia.camila.mypokedex.model.domain.User
import zubia.camila.mypokedex.model.preferences.PokemonSerializer

class UserViewModel(val users: Users, private val companionDataStore: CompanionPreferences): ViewModel(){
    var currentUser by mutableStateOf<User?>(null)
    init{
        currentUser = users.getCurrentUser()
    }
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")

    val companion: StateFlow<Pokemon> = companionDataStore.pokemonCompanion().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PokemonSerializer.defaultValue
    ) 

    fun login(user: String, password: String){
        val user = users.loginService(user, password)
        if (user == null){
            loginError = true
            errorDescription = "Ususario o contraseña incorrectos"
        }else{
           loginError = false
           errorDescription = ""
            users.saveUser(user.email, user.name)
        }
    }

    fun isLoggedIn(): Boolean{
        return users.isLoggedIn()
    }
}