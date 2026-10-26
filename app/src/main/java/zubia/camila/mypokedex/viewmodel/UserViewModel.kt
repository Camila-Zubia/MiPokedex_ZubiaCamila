package zubia.camila.mypokedex.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import zubia.camila.mypokedex.model.data.Users

class UserViewModel(val users: Users): ViewModel(){
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")

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