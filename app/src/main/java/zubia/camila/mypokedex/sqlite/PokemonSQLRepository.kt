package zubia.camila.mypokedex.sqlite

import zubia.camila.mypokedex.model.data.interfaces.IPokemonDAO
import zubia.camila.mypokedex.model.data.interfaces.IPokemonRepository
import zubia.camila.mypokedex.model.domain.Pokemon

class PokemonSQLRepository(val dao: PokemonDAO): IPokemonRepository {
    override suspend fun addPokemon(pokemon: Pokemon) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun getPokemons(): List<Pokemon> {
        return dao.getAllPokemons()
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        return dao.getFavoritePokemons()
    }

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return dao.getPokemonsByType(type)
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        dao.updatePokemon(pokemon)
    }

    override suspend fun deletePokemon(id: Int) {
        dao.deletePokemon(id)
    }
}