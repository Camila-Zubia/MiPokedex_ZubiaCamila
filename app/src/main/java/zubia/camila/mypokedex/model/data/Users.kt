package zubia.camila.mypokedex.model.data

import android.content.Context
import zubia.camila.mypokedex.model.domain.User
import zubia.camila.mypokedex.model.preferences.ARCHIVO
import zubia.camila.mypokedex.model.preferences.USER
import zubia.camila.mypokedex.model.preferences.USERNAME

class Users(val context: Context) {
    val validUsers = listOf<User>(
        User("alma@mail.com", "123456", "Alma Chavez"),
        User("camila.zubia@mail.com", "150404", "Camila Zubia"),
        User("taylor@mail.com", "1989", "TaylorSwift")
    )

    fun getUserByMail(mail: String?): User?{
        return validUsers.firstOrNull { it.email.equals(mail, ignoreCase = true) }
    }

    fun loginService(user: String, pass: String): User? {
        val user = getUserByMail(user)
        user.let{
            if(user?.password == pass)
                return user
        }
        return null
    }

    val shared = context.getSharedPreferences( ARCHIVO, Context.MODE_PRIVATE)
    fun saveUser(user: String, name: String){
        val editor = shared.edit()
        editor.putString(USER, user)
        editor.putString(USERNAME, name)
        editor.apply()
    }

    fun getCurrentUser(): User? {
        val user = shared.getString( USER, null )
        return getUserByMail(user)
    }

    fun logout(){
        val editor = shared.edit()
        editor.putString(USER, null)
        editor.putString(USERNAME, null)
        editor.apply()
    }

    fun isLoggedIn(): Boolean{
        return getCurrentUser() != null
    }
}
