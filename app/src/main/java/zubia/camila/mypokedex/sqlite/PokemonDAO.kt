package zubia.camila.mypokedex.sqlite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import zubia.camila.mypokedex.model.data.interfaces.IPokemonDAO
import zubia.camila.mypokedex.model.domain.Pokemon

class PokemonDAO(private val dbHelper: DatabaseHelper): IPokemonDAO{
    val mapper = PokemonMapper()
    override suspend fun insertPokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO){
            val db = dbHelper.writableDatabase
            db.insert(Contract.Pokemons.TABLE_NAME, null,
                mapper.getContentValues(pokemon))
            db.close()
        }
    }

    override suspend fun getAllPokemons(): List<Pokemon> {
        return withContext(Dispatchers.IO){
            val db = dbHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME}"
            val cursor = db.rawQuery(query, null)
            cursor.use {
                c ->
                buildList {
                    while (c.moveToNext()){
                        add(mapper.getPokemon(cursor))
                    }
                }
            }
        }
    }

    override suspend fun getPokemonById(id: Int): Pokemon? {
        return withContext(Dispatchers.IO) {
            val db = dbHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_ID} = ?"

            db.rawQuery(query, arrayOf(id.toString())).use { cursor ->
                if (cursor.moveToFirst()) {
                    mapper.getPokemon(cursor)
                } else {
                    null
                }
            }
        }
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = dbHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_NAME_FAV} = ?"
            val favoriteList = mutableListOf<Pokemon>()

            db.rawQuery(query, arrayOf("1")).use { cursor ->
                while (cursor.moveToNext()) {
                    favoriteList.add(mapper.getPokemon(cursor))
                }
            }

            favoriteList
        }
    }

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = dbHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_NAME_TYPE} = ?"
            val typeList = mutableListOf<Pokemon>()

            db.rawQuery(query, arrayOf(type)).use { cursor ->
                while (cursor.moveToNext()) {
                    typeList.add(mapper.getPokemon(cursor))
                }
            }

            typeList
        }
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = dbHelper.writableDatabase
            val values = mapper.getContentValues(pokemon)
            val whereClause = "${Contract.Pokemons.COLUMN_NAME_NUMBER} = ?"
            val whereArgs = arrayOf(pokemon.num)

            db.update(
                Contract.Pokemons.TABLE_NAME,
                values,
                whereClause,
                whereArgs as Array<out String?>?
            )
        }
    }

    override suspend fun deletePokemon(id: Int) {
        withContext(Dispatchers.IO) {
            val db = dbHelper.writableDatabase
            val whereClause = "${Contract.Pokemons.COLUMN_NAME_NUMBER} = ?"
            val whereArgs = arrayOf(id)

            db.delete(
                Contract.Pokemons.TABLE_NAME,
                whereClause,
                whereArgs as Array<out String?>?
            )
        }
    }
}