package zubia.camila.mypokedex

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import zubia.camila.mypokedex.model.data.Users
import zubia.camila.mypokedex.navigation.MyApp
import zubia.camila.mypokedex.screens.LoginScreen
import zubia.camila.mypokedex.ui.theme.MyPokedexTheme
import zubia.camila.mypokedex.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = Users(this)
        val userViewModel = UserViewModel(users)
        enableEdgeToEdge()
        setContent {
            MyPokedexTheme{
                Scaffold(modifier = Modifier.fillMaxWidth(), contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)) { innerPadding ->
                    MyApp(innerPadding, userViewModel)
                }
            }
        }
    }
}