package zubia.camila.mypokedex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import zubia.camila.mypokedex.model.data.CompanionPreferences
import zubia.camila.mypokedex.model.data.Users
import zubia.camila.mypokedex.navigation.MyApp
import zubia.camila.mypokedex.sqlite.DatabaseHelper
import zubia.camila.mypokedex.sqlite.PokemonDAO
import zubia.camila.mypokedex.sqlite.PokemonSQLRepository
import zubia.camila.mypokedex.ui.theme.MyPokedexTheme
import zubia.camila.mypokedex.viewmodel.AddPokemonViewModel
import zubia.camila.mypokedex.viewmodel.PokemonDetailViewModel
import zubia.camila.mypokedex.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = Users(this)
        val companion = CompanionPreferences(this)
        val userViewModel = UserViewModel(users, companion)
        val pokemonDetailVM = PokemonDetailViewModel(companion)
        val addPokemonVM = AddPokemonViewModel(PokemonSQLRepository(PokemonDAO(DatabaseHelper(this))))
        enableEdgeToEdge()
        setContent {
            MyPokedexTheme{
                Scaffold(modifier = Modifier.fillMaxWidth(), contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)) { innerPadding ->
                    MyApp(innerPadding, userViewModel, addPokemonVM, pokemonDetailVM)
                }
            }
        }
    }
}