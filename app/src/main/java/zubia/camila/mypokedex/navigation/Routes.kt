package zubia.camila.mypokedex.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
object PokemonHunt


@Serializable
data class PokemonDetail(val id: Int)