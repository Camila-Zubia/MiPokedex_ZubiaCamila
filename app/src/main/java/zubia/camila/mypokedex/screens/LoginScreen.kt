package zubia.camila.mypokedex.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import zubia.camila.mypokedex.viewmodel.UserViewModel

@SuppressLint("RememberReturnType")
@Composable
fun LoginScreen(innerPadding: PaddingValues, viewModel: UserViewModel = viewModel(), onNavigateToMenu: () -> Unit){
    var user by remember { mutableStateOf("") }
    var password = remember { TextFieldState() }
    if (viewModel.isLoggedIn()){
        onNavigateToMenu()
    }else{
        Column(Modifier
            .padding(15.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text("Usuario:", style= MaterialTheme.typography.labelLarge)
            TextField(value= user, label= {Text("Tu usuario")}, onValueChange = { it -> user= it}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), modifier =  Modifier.fillMaxWidth())
            Spacer(Modifier.size(30.dp))
            Text("Contraseña:", style= MaterialTheme.typography.labelLarge)
            SecureTextField(state= password, label= {Text("Tu contraseña")}, textObfuscationMode = TextObfuscationMode.RevealLastTyped, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), modifier =  Modifier.fillMaxWidth())
            Spacer(Modifier.size(30.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {viewModel.login(user, password.text as String)
                    if (!viewModel.loginError){
                        onNavigateToMenu
                    }}) {
                    Text("Iniciar Sesión")
                }
                Spacer(Modifier.size(40.dp))
                if (viewModel.loginError){
                    Text(viewModel.errorDescription, color= Color.Red, fontStyle = FontStyle.Italic)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(){
    LoginScreen(PaddingValues(), viewModel(),{ })
}