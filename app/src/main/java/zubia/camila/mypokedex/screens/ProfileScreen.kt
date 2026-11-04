package zubia.camila.mypokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import zubia.camila.mypokedex.model.data.bulbasaur
import zubia.camila.mypokedex.model.data.pokemonList
import zubia.camila.mypokedex.ui.theme.Purple40
import zubia.camila.mypokedex.ui.theme.Typography
import zubia.camila.mypokedex.utilities.getColorByType
import zubia.camila.mypokedex.viewmodel.UserViewModel

@Composable
fun ProfileScreen(innerPadding: PaddingValues, userViewModel: UserViewModel = viewModel()){
    Column(Modifier.fillMaxSize().padding(innerPadding).padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(if (userViewModel.currentUser != null)"${userViewModel.currentUser!!.name}" else "nombre usuario",
            style = Typography.displayLarge, color = Purple40
        )
        Text(if (userViewModel.currentUser != null)"${userViewModel.currentUser!!.email}" else "usuario@mail.com",
            style = Typography.titleLarge, color = Purple40
        )
        Spacer(Modifier.size(50.dp))
        Text("Mi compañero", style = Typography.titleLarge)
        val pokemon = if (userViewModel.currentUser != null){
            userViewModel.currentUser!!.pokemonCompanion
        }else{
            bulbasaur
        }
        Image(painterResource(pokemon.image), contentDescription = pokemon.name + "image")
        Text(pokemon.name, style= Typography.titleMedium, color = getColorByType(pokemon.type).first)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen(){
    ProfileScreen(PaddingValues())
}