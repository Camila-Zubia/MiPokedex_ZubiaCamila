package zubia.camila.mypokedex.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import zubia.camila.mypokedex.R
import zubia.camila.mypokedex.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(navController: NavController){
    TopAppBar(title = {
        Text("Pokedex", style = Typography.labelLarge)
    }, navigationIcon = {
        Icon(painter = painterResource(R.drawable.ic_logout), contentDescription = "logout")
    }, actions = {

    })
}
