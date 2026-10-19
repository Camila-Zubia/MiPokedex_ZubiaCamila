package zubia.camila.mypokedex.model.data

import zubia.camila.mypokedex.model.domain.User

val validUsers = listOf<User>(
    User("alma@mail.com", "123456", "Alma Chavez"),
    User("camila.zubia@mail.com", "150404", "Camila Zubia"),
    User("taylor@mail.com", "1989", "TaylorSwift")
)

fun getUserByMail(mail: String): User{
    return validUsers.first { it.email.equals(mail, ignoreCase = true) }
}

fun loginService(user: String, pass: String): User? {
    val user = getUserByMail(user)
    user.let{
        if(user.password == pass)
            return user
    }
    return null
}